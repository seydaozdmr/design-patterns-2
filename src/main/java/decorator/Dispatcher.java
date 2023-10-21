package decorator;

public class Dispatcher {

    public void handle(Book product){
        Length mm7 = Length.MILLIMETER.scale(7);

        System.out.println(product.getTitle() + product.getDimensions().add(new Size(mm7,mm7,mm7)));

    }
}
