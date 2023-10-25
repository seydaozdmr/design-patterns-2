package adaptor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {
    private static List<String> skipWords = Arrays.asList(
            "no", "nor", "not", "off", "out", "so", "up", "a",
            "and", "as", "at", "but", "by", "en", "for", "if",
            "in", "of", "on", "or", "the", "to", "v", "vs",
            "via", "an", "the"
    );

    private static Iterable<String> skipWordsRussian = Arrays.asList(
            "я", "мы", "ты", "вы", "он", "она", "оно", "они"
    );


    private static Function<String,WordSet> getWordSetFactory (Iterable<String> skipWords){
        return (text) -> new WordSet(text,skipWords);
    }
    public static void main(String[] args) {

        KeywordIndex<WithSimpleKeywords> index = new KeywordIndex<>();
        Book item = new Book("The Longest Book Ever","long","boring");
        Video video = new Video("Making the Long, Long ad","making-the-long-long-ad");
        KeywordRepository repository = new KeywordRepository();

        WithSimpleKeywords item2 = new PresentKeywords(new VideoWithKeyword(video,getWordSetFactory(skipWords)), repository.findFor(video.getHandle()));

        Video yetAnotherItem = new Video("Братья Карамазовы", "karamazov-brothers");
        WithSimpleKeywords item3 = new PresentKeywords(new VideoWithKeyword(yetAnotherItem, getWordSetFactory(skipWordsRussian)),repository.findFor(yetAnotherItem.getHandle()));

        index.add(item);
        index.add(item2);
        index.add(item3);

        System.out.println(index);

        String query = "long";

        String results = index.findApproximate(query).map(Object::toString).collect(Collectors.joining(", "));
        System.out.printf("Searching for %s : %s ",query,results);
    }
}
