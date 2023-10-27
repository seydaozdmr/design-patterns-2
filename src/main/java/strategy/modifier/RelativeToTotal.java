package strategy.modifier;

import strategy.Deduction;
import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

import java.math.BigDecimal;

/**
 * @author Seyda Özdemir
 * Bu sınıf toplam ürün miktarı üzerinden bir oranda indirim yapar ve ikinci üründen bu indirim düşülür.
 */
public class RelativeToTotal implements Deduction {
    private BigDecimal factor;

    public RelativeToTotal(double factor) {
        if(factor < 0 || factor > 1)
            throw new IllegalArgumentException();
        this.factor = BigDecimal.valueOf(factor);
    }

    @Override
    public Money from(Pair<Money, Money> pair) {
        return pair.getFirst().add(pair.getSecond()).scale(factor);//iki fiyatı toplayıp belirli oranda indirim döner

    }

}
