package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

public class GetOneFree implements PriceModifier {

    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        return Pair.of(pair.getFirst(), pair.getSecond().getCurrency().ZERO);
    }
}
