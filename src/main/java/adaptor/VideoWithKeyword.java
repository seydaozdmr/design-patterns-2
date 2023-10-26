package adaptor;

import java.util.*;
import java.util.function.Function;



public class VideoWithKeyword implements WithSimpleKeywords{
    private Video target;
    private Function<String,WordSet> wordSetFactory;

    public VideoWithKeyword(Video target, Function<String,WordSet> wordSetFactory) {
        this.target = target;
        this.wordSetFactory = wordSetFactory;
    }

    private WordSet createWordSet(){
        //method triggers this point
        return this.wordSetFactory.apply(this.target.getTitle());
    }

    @Override
    public Iterable<String> getKeywords(){
        return this.createWordSet().getWords();
    }

    @Override
    public String toString() {
        return "VideoWithKeyword{" +
                "video=" + target +
                '}';
    }
}
