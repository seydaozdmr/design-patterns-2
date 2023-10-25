package adaptor;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSet {

    List<String> words;

    public WordSet(String text, Iterable<String> skipWords){
        //this lines triggers lambda function
        this.words = brakeIntoWords(text,skipWords);

    }

    public Iterable<String> getWords(){
        return this.words;
    }

    private List<String> brakeIntoWords(String text, Iterable<String> skipWords) {
        Set<String> keywords = new HashSet<>();
        Matcher matcher = Pattern.compile("[\\p{L}0-9-]+").matcher(text);
        while (matcher.find()){
            keywords.add(matcher.group());
        }
        skipWords.forEach(keywords::remove);
        return new ArrayList<>(keywords);
    }
}
