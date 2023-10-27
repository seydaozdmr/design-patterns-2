package strategy;

public interface PriceModifier {
    Pair<Money,Money> modify(Pair<Money,Money> pair);
}
