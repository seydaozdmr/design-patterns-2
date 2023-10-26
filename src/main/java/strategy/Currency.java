package strategy;

import java.math.BigDecimal;

public final class Currency {
    private String symbol;

    public Currency(String symbol) {
        this.symbol = symbol;
    }

    public final Money ZERO =
            new Money(BigDecimal.ZERO, this);

    public final Money MIN_POSITIVE_VALUE =
            new Money(BigDecimal.valueOf(0.01), this);

    public Money of(BigDecimal amount) {
        return new Money(amount, this);
    }

    public Money of(long amount) {
        return this.of(BigDecimal.valueOf(amount));
    }

    public String toString() { return this.symbol; }

    public boolean equals(Currency other) {
        return other != null && other.symbol.equals(this.symbol);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Currency && this.equals((Currency)obj);
    }

    @Override
    public int hashCode() { return this.symbol.hashCode(); }
}
