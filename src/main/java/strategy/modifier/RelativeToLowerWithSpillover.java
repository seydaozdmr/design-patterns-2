package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

import java.math.BigDecimal;

/**
 * @author Seyda Özdemir
 * Bu sınıf en düşük fiyatlı ürüne belirli bir yüzdede indirim yapar, eğer indirim sonucunda kalan olmuşsa bu miktarı diğer üründen düşer.
 */
public class RelativeToLowerWithSpillover implements PriceModifier {
    private BigDecimal factor;

    public RelativeToLowerWithSpillover(double factor) {
        if(factor < 0 || factor > 1)
            throw new IllegalArgumentException();
        this.factor = BigDecimal.valueOf(factor);
    }

    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        Money totalDeduction = lower(pair).scale(factor);
        Money bDeduction = pair.getSecond().min(totalDeduction); //indirimi 2. ürüne yapar.
        Money spill = totalDeduction.subtract(bDeduction); //indirimden kalan
        Money aDeduction = pair.getFirst().subtract(spill);

        return Pair.of(pair.getFirst().subtract(aDeduction),pair.getSecond().subtract(bDeduction));
    }

    private Money lower(Pair<Money,Money> pair){
        return pair.getFirst().min(pair.getSecond());
    }
}
