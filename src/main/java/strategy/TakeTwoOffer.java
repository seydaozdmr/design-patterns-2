package strategy;

import java.util.function.Function;

public class TakeTwoOffer {
    private PriceModifier modifier; //strategy

    public TakeTwoOffer(PriceModifier modifier) {
        this.modifier = modifier;
    }

    public Pair<Book, Book> apply(Book first, Book second) {
        Pair<Book,Book> books = this.sort(first,second);
        return this.modifier.modify(books.map(Book::getPrice,Book::getPrice))
                .map(
                        price1 -> books.getFirst().withEffectivePrice(price1),
                        price2 -> books.getSecond().withEffectivePrice(price2)
                );
    }

    private Pair<Book, Book> sort(Book first, Book second) {
        return first.getPrice().compareTo(second.getPrice()) >= 0
                ? Pair.of(first, second)
                : Pair.of(second, first);
    }
}
