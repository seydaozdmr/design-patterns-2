package decorator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Length implements Comparable<Length>{
    public static final Length ZERO = new Length(BigDecimal.ZERO);
    public static final Length MILLIMETER = new Length(BigDecimal.valueOf(.001));
    private BigDecimal meters;

    public Length(BigDecimal meters) {
        this.meters = meters.setScale(4, RoundingMode.HALF_UP);
    }

    public Length add(Length other){
        return new Length(this.meters.add(other.meters));
    }

    public Length scale(double factor){
        return new Length(this.meters.multiply(BigDecimal.valueOf(factor)));
    }

    public Length max(Length other){
        return this.compareTo(other) >= 0 ? this : other;
    }

    public static Length max(Length first, Length... others){
        Length winner= first;
        for(Length elem: others){
            winner = winner.max(elem);
        }
        return winner;
    }

    @Override
    public int compareTo(Length o) {
        return this.meters.compareTo(o.meters);
    }

    @Override
    public String toString() {
        return "Length{" +
                "meters=" + meters +
                '}';
    }
}
