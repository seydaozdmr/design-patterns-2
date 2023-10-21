package decorator;

public abstract class BookDecorator implements Book{
    private Book baseBook;

    public BookDecorator(Book book){
        this.baseBook =book;
    }

    @Override
    public String getTitle() {
        return baseBook.getTitle();
    }

    @Override
    public Size getDimensions(){
        return baseBook.getDimensions();
    }

    @Override
    public Size getDimensions(Size propaganda) {
        return this.getDimensions().addToTop(propaganda);
    }
}
