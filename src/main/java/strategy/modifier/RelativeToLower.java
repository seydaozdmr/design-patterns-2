package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

import java.math.BigDecimal;

/**
 * @autor Seyda Özdemir
 * Bu sınıf daha uygun fiyatlı ürüne belirli bir yüzdede indirim uygulayan stratejidir.
 */
public class RelativeToLower  implements PriceModifier {
    private BigDecimal factor;

    public RelativeToLower(double factor) {
        if(factor < 0 || factor >1)
            throw new IllegalArgumentException();
        this.factor = BigDecimal.valueOf(factor);
    }

    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        return this.applyTo(pair.getFirst(),pair.getSecond(),lower(pair).scale(this.factor));
    }

    private Money lower(Pair<Money,Money> pair){
        return pair.getFirst().min(pair.getSecond());
    }

    private Pair<Money,Money> applyTo(Money a,Money b,Money discount){
        return Pair.of(a,b.subtract(b.min(discount)));
    }
}
