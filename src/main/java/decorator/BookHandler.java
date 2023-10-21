package decorator;

public class BookHandler {

    public void handle(Book book){
        Length mm = Length.MILLIMETER;
        Size slimCdCase = new Size(mm.scale(142),mm.scale(125),mm.scale(5));
        Size dimensions = book.getDimensions(slimCdCase);
        System.out.println("Title : "+book.getTitle()+", dimensions: "+dimensions);
    }
}
