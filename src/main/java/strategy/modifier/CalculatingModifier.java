package strategy.modifier;

import strategy.Deduction;
import strategy.Money;
import strategy.Pair;
import strategy.PriceModifier;

public abstract class CalculatingModifier implements PriceModifier {
    private Deduction deduction; //indirimin tipini ekliyoruz (kesin fir fiyat indirimi, en düşüğe yüzde, toplam ürün fiyatına yüzde)

    public CalculatingModifier(Deduction deduction) {
        this.deduction = deduction;
    }

    @Override
    public Pair<Money, Money> modify(Pair<Money, Money> pair) {
        return this.applyTo(pair.getFirst(),pair.getSecond(),deduction.from(pair));
    }

    protected abstract Pair<Money,Money> applyTo (Money a,Money b,Money deduction);
}
