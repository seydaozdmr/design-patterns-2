package strategy.modifier;

import strategy.Money;
import strategy.PriceModifier;

public class GetOneFree implements PriceModifier {
    @Override
    public Money modify(Money money) {
        return money.getCurrency().ZERO;
    }
}
