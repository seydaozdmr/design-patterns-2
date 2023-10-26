package strategy;

import java.util.function.Function;

public class TakeTwoOffer {
    private PriceModifier modifier;

    public TakeTwoOffer(PriceModifier modifier) {
        this.modifier = modifier;
    }

    public Pair<Book, Book> apply(Book first, Book second) {
        return this.discountSecond(this.sort(first, second));
    }

    private Pair<Book, Book> discountSecond(Pair<Book, Book> books) {
        return books.mapSecond(cheaper ->
                cheaper.withEffectivePrice(this.modifier.modify(cheaper.getPrice())));
    }

    private Pair<Book, Book> sort(Book first, Book second) {
        return first.getPrice().compareTo(second.getPrice()) >= 0
                ? Pair.of(first, second)
                : Pair.of(second, first);
    }
}
