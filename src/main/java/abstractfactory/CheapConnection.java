package abstractfactory;

import java.util.ArrayList;

public class CheapConnection implements Connection{
    private String database;
    private String userName;
    private String password;

    public CheapConnection(String database, String userName, String password) {
        this.database = database;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void connect(String connectionString) {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public Object execute(Command command, Transaction transaction) {
        return this.execute((CheapCommand) command,(CheapTransaction) transaction);
    }

    public Object execute(CheapCommand command,CheapTransaction transaction){
        return this.sendCommand(command.getText(),transaction);
    }
    public Object sendCommand(String text){
        return text.contains("TRANSACTION") ? 5 : new Object();
    }
    private Object sendCommand(String text, CheapTransaction transaction){
        return new Object();
    }
}
