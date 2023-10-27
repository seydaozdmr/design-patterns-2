package strategy;

import strategy.modifier.*;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        Currency usd = new Currency("USD");

        apply(new GetSecondFree());
        apply(new FromSecondWithSpillover(new Absolute(usd.of(12))));
        apply(new FromSecondWithSpillover(new RelativeToTotal(.1)));
        apply(new FromSecondWithSpillover(new RelativeToTotal(.25)));
        apply(new Proportional(new Absolute(usd.of(12))));
    }

    private static void apply(PriceModifier modifier) {
        apply(new TakeTwoOffer(modifier));
    }

    private static void apply(TakeTwoOffer offer) {
        Book first = new Book(
                "Design Patterns: Elements of Reusable Object-oriented Software",
                new Money(BigDecimal.valueOf(35), new Currency("USD")));
        Book second = new Book(
                "The Little Prince",
                new Money(BigDecimal.valueOf(9), new Currency("USD")));

        Pair<Book, Book> cart = offer.apply(second, first);

        System.out.println();
        System.out.println(cart.getFirst());
        System.out.println(cart.getSecond());
    }
}
