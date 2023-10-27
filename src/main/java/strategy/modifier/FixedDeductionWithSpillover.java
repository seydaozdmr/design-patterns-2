package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

public class FixedDeductionWithSpillover implements PriceModifier {
    private Money amount;

    public FixedDeductionWithSpillover(Money amount) {
        this.amount = amount;
    }

    @Override
    public Pair<Money,Money> modify(Pair<Money,Money> pairs) {
        Money deduct = pairs.getSecond().min(this.amount);
        Money spill = this.amount.subtract(deduct);
        Money deductSpill = pairs.getFirst().min(spill);

        return pairs.map(first -> first.subtract(deductSpill),second -> second.subtract(deduct));
    }
}
