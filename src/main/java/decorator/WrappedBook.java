package decorator;

public class WrappedBook extends BookDecorator{
    public WrappedBook(Book other) {
        super(other);
    }
    @Override
    public Size getDimensions() {
        Length mm7 = Length.MILLIMETER.scale(7);
        return super.getDimensions().add(new Size(mm7,mm7,mm7));
    }


}
