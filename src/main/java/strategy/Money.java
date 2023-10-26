package strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class Money implements Comparable<Money> {
    private BigDecimal amount;
    private Currency currency;

    public Money(BigDecimal amount, Currency currency)
    {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException();
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
        this.currency = currency;
    }

    public boolean isCompatibleWith(Money other) {
        return this.currency.equals(other.currency);
    }

    public Currency getCurrency() { return this.currency; }

    public Money subtractAmount(BigDecimal amount) {
        return this.subtract(this.currency.of(amount));
    }

    public Money subtractAmount(long amount) {
        return this.subtractAmount(BigDecimal.valueOf(amount));
    }

    public Money scale(BigDecimal factor) {
        return new Money(this.amount.multiply(factor), this.currency);
    }

    public Money scaleDown(BigDecimal factor) {
        return new Money(this.amount.divide(factor), this.currency);
    }

    public BigDecimal divide(Money other) {
        return this.currency.equals(other.currency) ? this.amount.divide(other.amount, 4, RoundingMode.HALF_UP)
                : raiseCurrencyError("divide", this, other);
    }

    public Money add(Money other) {
        return this.currency.equals(other.currency) ? new Money(this.amount.add(other.amount), this.currency)
                : raiseCurrencyError("add", this, other);
    }

    public Money subtract(Money other) {
        if (this.compareTo(other) < 0)
            throw new IllegalArgumentException("Not enough funds");
        return new Money(this.amount.subtract(other.amount), this.currency);
    }

    public Money min(Money other) {
        return this.compareTo(other) <= 0 ? this : other;
    }

    private static Boolean raiseCurrencyComparisonError(Money a, Money b) {
        return raiseCurrencyError("compare", a, b);
    }

    private static <T> T raiseCurrencyError(String operation, Money a, Money b) {
        throw new IllegalArgumentException("Cannot " + operation + " " + a.currency+ " and " + b.currency);
    }

    @Override
    public String toString() {
        return new DecimalFormat("#,##0.00").format(this.amount) + " " + this.currency;
    }

    public boolean equals(Money other) {
        return
                other != null &&
                        this.amount.equals(other.amount) &&
                        this.currency.equals(other.currency);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Money && this.equals((Money)obj);
    }

    @Override
    public int hashCode() {
        return (this.amount.hashCode() * 397) ^ this.currency.hashCode();
    }

    @Override
    public int compareTo(Money other) {
        return this.currency.equals(other.currency) ? this.amount.compareTo(other.amount)
                : raiseCurrencyError("compare", this, other);
    }
}
