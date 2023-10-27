package strategy.modifier;

import strategy.Deduction;
import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

import java.math.BigDecimal;

/**
 * @autor Seyda Özdemir
 * Bu sınıf daha uygun fiyatlı ürüne belirli bir yüzdede indirim uygulayan stratejidir.
 */
public class RelativeToLower  implements Deduction {
    private BigDecimal factor;

    public RelativeToLower(double factor) {
        if(factor < 0 || factor >1)
            throw new IllegalArgumentException();
        this.factor = BigDecimal.valueOf(factor);
    }

    @Override
    public Money from(Pair<Money, Money> pair) {
        return pair.getFirst().min(pair.getSecond()).scale(factor); //düşük fiyatlı olanı bulup onun fiyatının yüzdesinde indirim yapar.
    }

}
