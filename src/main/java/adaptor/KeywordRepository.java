package adaptor;

import java.util.Arrays;
import java.util.Collections;

public class KeywordRepository {

    public Iterable<String> findFor(String videoHandle){
        return videoHandle.equals("karamazov-brothers") ? Arrays.asList("karamazov", "brothers") : Collections.emptyList();
    }
}
