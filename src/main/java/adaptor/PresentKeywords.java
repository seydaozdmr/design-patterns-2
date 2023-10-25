package adaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PresentKeywords implements WithSimpleKeywords{
    private WithSimpleKeywords target;
    private List<String> substituteKeywords;

    public PresentKeywords(WithSimpleKeywords target, Iterable<String> substituteKeywords) {
        this.target = target;
        this.substituteKeywords= new ArrayList<>();
        substituteKeywords.forEach(this.substituteKeywords::add);
    }


    @Override
    public Iterable<String> getKeywords() {
        //first fetch from repo(db) if not target's function
        return !this.substituteKeywords.isEmpty() ? this.substituteKeywords : this.target.getKeywords();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresentKeywords that = (PresentKeywords) o;
        return Objects.equals(target, that.target) && Objects.equals(substituteKeywords, that.substituteKeywords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, substituteKeywords);
    }

    @Override
    public String toString() {
        return "PresentKeywords{" +
                "target=" + target +
                ", substituteKeywords=" + substituteKeywords +
                '}';
    }
}
