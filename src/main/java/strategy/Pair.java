package strategy;

import java.util.function.Function;

public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    private Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public static <T1, T2> Pair<T1, T2> of(T1 first, T2 second) {
        return new Pair(first, second);
    }

    public T1 getFirst() { return this.first; }
    public T2 getSecond() { return this.second; }

    public <TResult> Pair<TResult, T2> mapFirst(Function<T1, TResult> map) {
        return new Pair(map.apply(this.first), second);
    }

    public <TResult> Pair<T1, TResult> mapSecond(Function<T2, TResult> map) {
        return new Pair(this.first, map.apply(this.second));
    }

    public <TResult1, TResult2> Pair<TResult1, TResult2> map(Function<T1, TResult1> map1, Function<T2, TResult2> map2) {
        return new Pair(map1.apply(this.first), map2.apply(this.second));
    }
}

