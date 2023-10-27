package strategy.modifier;

import strategy.Deduction;
import strategy.Money;
import strategy.Pair;

/**
 * @author Seyda Özdemir
 * indirim miktarını 2. üründen düşen strateji
 */

public class FromSecond extends CalculatingModifier{

    public FromSecond(Deduction deduction) {
        super(deduction);
    }

    @Override
    protected Pair<Money, Money> applyTo(Money a, Money b, Money deduction) {
        return Pair.of(a,b.subtract(b.min(deduction)));
    }
}
