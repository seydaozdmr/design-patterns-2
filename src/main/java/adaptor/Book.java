package adaptor;

import java.util.Arrays;
import java.util.List;

public class Book implements WithSimpleKeywords{
    private final String title;
    private final List<String> keywords;

    public Book(String title, String... keywords) {
        this.title = title;
        this.keywords = Arrays.asList(keywords);
    }

    public String getTitle() {
        return title;
    }

    public Iterable<String> getKeywords(){
        return this.keywords;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
