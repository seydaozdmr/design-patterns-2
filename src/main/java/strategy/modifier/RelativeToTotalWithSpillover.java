package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

import java.math.BigDecimal;

/**
 * @autor Seyda Özdemir
 * Bu sınıf sepet toplamı üzerinden
 */
public class RelativeToTotalWithSpillover implements PriceModifier {
    private BigDecimal factor;

    public RelativeToTotalWithSpillover(double factor) {
        if(factor < 0 || factor > 1)
            throw new IllegalArgumentException();
        this.factor = BigDecimal.valueOf(factor);
    }

    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        Money sum = pair.getFirst().add(pair.getSecond());
        Money totalDeduction = sum.scale(this.factor);
        Money bDeduction = pair.getSecond().min(totalDeduction); //ikinci ürüne indirim uygulandıktan sonra kalan
        Money spill = totalDeduction.subtract(bDeduction);
        Money aDeduction = pair.getFirst().min(spill); //tüm indirimden geriye kalan varsa 1. ürüne kalan indirimi uygula
        return pair.of(pair.getFirst().subtract(aDeduction),pair.getSecond().subtract(bDeduction));
    }
}
