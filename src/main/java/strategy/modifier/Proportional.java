package strategy.modifier;

import strategy.Deduction;
import strategy.Money;
import strategy.Pair;

import java.math.BigDecimal;

/**
 * @author Seyda Özdemir
 * yapılan indirimi orantılı olarak ürünlere dağıtan ve düşen strateji
 */

public class Proportional extends CalculatingModifier{
    public Proportional(Deduction deduction) {
        super(deduction);
    }

    @Override
    protected Pair<Money, Money> applyTo(Money a, Money b, Money deduction) {
        BigDecimal factor = b.divide(a.add(b));   //90 10 -> 100  10/100 -> 0.1
        Money bDeductionFull = deduction.scale(factor); //20 lira deduction -> 20*0.1 -> 2 indirim
        Money bDeduction = b.min(bDeductionFull); //10 <> 2 -> 2
        Money spill = deduction.subtract(bDeduction); //10 - 2 -> 8
        Money aDeduction = a.min(spill); // 8
        return Pair.of(a.subtract(aDeduction),b.subtract(bDeduction));
    }
}
