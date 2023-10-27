package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

/**
 * @autor Seyda Özdemir
 * Bu sınıf ikinci üründen belirli bir fiyat miktarının düşürülmesini hedefleyen stratejidir.
 */

public class Absolute implements PriceModifier {
    private Money amount;

    public Absolute(Money amount) {
        this.amount = amount;
    }


    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        return Pair.of(pair.getFirst(), pair.getSecond().subtract(pair.getSecond().min(this.amount)));
    }
}
