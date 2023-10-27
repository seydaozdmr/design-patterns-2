package strategy.modifier;

import strategy.Deduction;
import strategy.Money;
import strategy.Pair;

public class FromSecondWithSpillover extends CalculatingModifier{
    public FromSecondWithSpillover(Deduction deduction) {
        super(deduction);
    }

    @Override
    public Pair<Money, Money> applyTo(Money a, Money b, Money deduction) {
        Money bDeduction = b.min(deduction);
        Money spill = deduction.subtract(bDeduction);
        Money aDeduction = a.min(spill);

        return Pair.of(a.subtract(aDeduction), b.subtract(bDeduction));
    }
}
