package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

import java.math.BigDecimal;

/**
 * @author Seyda Özdemir
 * Bu sınıf toplam ürün miktarı üzerinden bir oranda indirim yapar ve ikinci üründen bu indirim düşülür.
 */
public class RelativeToTotal implements PriceModifier {
    private BigDecimal factor;

    public RelativeToTotal(double factor) {
        if(factor < 0 || factor > 1)
            throw new IllegalArgumentException();
        this.factor = BigDecimal.valueOf(factor);
    }

    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        return this.applyTo(pair.getFirst(),pair.getSecond(),pair.getFirst().add(pair.getSecond().scale(this.factor)));
    }

    private Pair<Money,Money> applyTo(Money a, Money b, Money discount){
        return Pair.of(a, b.subtract(b.min(discount)));
    }
}
