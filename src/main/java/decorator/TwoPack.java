package decorator;

public class TwoPack extends BookDecorator{
    public TwoPack(Book book) {
        super(book);
    }

    @Override
    public Size getDimensions() {
        return super.getDimensions().scaleHeight(2);
    }
}
