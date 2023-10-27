package strategy.modifier;

import strategy.Deduction;
import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

/**
 * @autor Seyda Özdemir
 * Bu sınıf ikinci üründen belirli bir fiyat miktarının düşürülmesini hedefleyen stratejidir.
 */

public class Absolute implements Deduction {
    private Money amount;

    public Absolute(Money amount) {
        this.amount = amount;
    }


    @Override
    public Money from(Pair<Money, Money> pair) {
        return amount;
    }
}
