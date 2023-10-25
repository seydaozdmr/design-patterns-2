package adaptor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeywordIndex<T extends WithSimpleKeywords>{
    private Map<String, List<T>> index = new HashMap<>();

    public void add(T item){
        for(String keyword: item.getKeywords()){
            this.add(keyword.toLowerCase(Locale.ROOT),item);
        }
    }

    private void add(String keyword, T item){
        this.getListFor(keyword).add(item); //add item below index value
    }

    private List<T> getListFor(String keyword){
        return this.index.containsKey(keyword) ? this.index.get(keyword) : this.createListFor(keyword);
    }

    private List<T> createListFor(String keyword){
        List<T> list = new ArrayList<>();
        this.index.put(keyword, list);
        return list;
    }

    public Stream<T> find(String keyword){
        return this.index.getOrDefault(keyword,Collections.emptyList()).stream();
    }

    public Stream<T> findApproximate(String keyword){
        return this.index.entrySet().stream()
                .filter(entry -> entry.getKey().contains(keyword.toLowerCase(Locale.ROOT)))
                .flatMap(entry-> entry.getValue().stream());
    }

    @Override
    public String toString() {
        return this.index.entrySet().stream().flatMap(this::toString).collect(Collectors.joining("\n"));
    }

    public Stream<String> toString(Map.Entry<String,List<T>> entry){
        return entry.getValue().stream().map(book -> entry.getKey() + " -> "+book);
    }
}
