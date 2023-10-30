package abstractfactory;

public interface Connection {
    void connect(String connectionString);
    void disconnect();
    Object execute(Command command, Transaction transaction);
}
