package abstractfactory;

public class CheapCommand implements Command{
    private String text;

    public CheapCommand(String text) {
        this.text = text;
    }

    public String getText() {return this.text;}
}
