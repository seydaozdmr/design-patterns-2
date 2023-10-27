package strategy.modifier;

import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

/**
 * @autor Seyda Özdemir
 * Bu sınıf toplam indirim miktarı 2. üründen daha fazla ise, kalan indirim miktarını 1. üründen düşen bir strateji
 */

public class AbsoluteWithSpillover implements PriceModifier {
    private Money amount;

    public AbsoluteWithSpillover(Money amount) {
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
