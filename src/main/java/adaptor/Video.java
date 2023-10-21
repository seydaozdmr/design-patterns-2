package adaptor;

public class Video implements WithSimpleKeywords{
    private String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Iterable<String> getKeywords() {
        return null;
    }
}
