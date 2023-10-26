package strategy.modifier;

import strategy.Money;
import strategy.PriceModifier;

public class FixedDeduction implements PriceModifier {
    private Money amount;

    public FixedDeduction(Money amount) {
        this.amount = amount;
    }

    @Override
    public Money modify(Money money) {
        return money.subtract(money);
    }
}
