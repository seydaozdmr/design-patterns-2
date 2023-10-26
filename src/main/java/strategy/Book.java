package strategy;

public class Book {
    private String title;
    private Money price;
    private Money effectivePrice;

    public Book(String title, Money price) {
        this(title, price, price);
    }

    private Book(String title, Money price, Money effectivePrice) {
        if (!price.isCompatibleWith(effectivePrice))
            throw new IllegalArgumentException();

        this.title = title;
        this.price = price;
        this.effectivePrice = effectivePrice;
    }

    public Book withEffectivePrice(Money price) {
        return new Book(this.title, this.price, price);
    }

    public Money getPrice() { return this.price; }

    @Override
    public String toString() {
        return String.format("%s\n%s", this.title, this.priceToString());
    }

    private String priceToString() {
        return this.effectivePrice.equals(this.price) ? this.effectivePrice.toString()
                : String.format("%s (was %s)", this.effectivePrice, this.price);
    }
}
