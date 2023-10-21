package decorator;

public class Demo {

    public static void main(String[] args) {
        Length mm = Length.MILLIMETER;
        Size dimensions = new Size(mm.scale(188),mm.scale(239),mm.scale(28));
        Book bareBook = new PrintedBook("Design Patterns", dimensions); // -> Asıl nesne bu
        Book product = new TwoPack(bareBook); // -> nesneden iki tane olacak şekilde extend edilmiş hali

        BookHandler buyer = new BookHandler();
        buyer.handle(product);

        Book wrappedProduct = new WrappedBook(product);
        BookHandler dispatcher = new BookHandler();
        dispatcher.handle(wrappedProduct);


    }
}
