package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

public class FixedDeduction implements PriceModifier {
    private Money amount;

    public FixedDeduction(Money amount) {
        this.amount = amount;
    }


    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        return Pair.of(pair.getFirst(), pair.getSecond().subtract(pair.getSecond().min(this.amount)));
    }
}
