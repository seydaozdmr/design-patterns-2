package adaptor;

public class Video{
    private String title;
    private String handle;

    public Video(String title, String handle) {
        this.title = title;
        this.handle = handle;
    }

    public String getTitle() {
        return title;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", handle='" + handle + '\'' +
                '}';
    }
}
