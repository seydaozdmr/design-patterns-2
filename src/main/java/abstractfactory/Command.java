package abstractfactory;

public interface Command {
    Object execute(Transaction transaction);
}
