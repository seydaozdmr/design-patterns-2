package strategy;

public interface PriceModifier {
    Money modify(Money money);
}
