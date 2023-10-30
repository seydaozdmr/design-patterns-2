package abstractfactory;

public interface DataAccess {
    Connection createConnection(String connectionString);
    Command createCommand(String commandText);
    Transaction createTransaction(Connection connection);

}
