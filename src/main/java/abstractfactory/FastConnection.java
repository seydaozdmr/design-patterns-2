package abstractfactory;

public class FastConnection implements Connection{
    private String server;
    private String database;
    private Credentials credentials;

    public FastConnection(String server, String database, Credentials credentials) {
        this.server = server;
        this.database = database;
        this.credentials = credentials;
    }

    @Override
    public void connect(String connectionString) {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public Object execute(Command command, Transaction transaction) {
        return null;
    }
}
