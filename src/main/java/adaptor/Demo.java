package adaptor;

import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        KeywordIndex<Book> index = new KeywordIndex<>();
        Book item = new Book("The Longest Book Ever","long","boring");

        index.add(item);

        System.out.println(index);

        String query = "long";

        String results = index.find(query).map(Book::toString).collect(Collectors.joining(", "));
        System.out.printf("Searching for %s : %s ",query,results);
    }
}
