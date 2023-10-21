package decorator;

public class PrintedBook implements Book{
    private String title;
    private Size dimensions;

    public PrintedBook(String title, Size dimensions) {
        this.title = title;
        this.dimensions = dimensions;
    }

    public String getTitle() {
        return title;
    }

    public Size getDimensions() {
        return this.dimensions;
    }

    public Size getDimensions(Size propaganda){
        return this.getDimensions().addToTop(propaganda);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", dimensions=" + dimensions +
                '}';
    }
}
