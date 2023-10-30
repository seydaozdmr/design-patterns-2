package abstractfactory;

import abstractfactory.commands.Delete;
import abstractfactory.commands.Insert;
import abstractfactory.commands.Select;
import abstractfactory.commands.Update;

public class FastDataAccess implements DataAccess{
    @Override
    public Connection createConnection(String connectionString) {
        return this.createConnection(new ConnectionData(connectionString));
    }
    private Connection createConnection(ConnectionData connectionData){
        return new FastConnection(connectionData.getServer(), connectionData.getDatabase(), connectionData.getCredentials());
    }

    @Override
    public Command createCommand(String commandText) {
        return commandText.startsWith("INSERT INTO ") ? new Insert(commandText) :
               commandText.startsWith("DELETE FROM ") ? new Delete(commandText) :
               commandText.startsWith("UPDATE ") ? new Update(commandText) :
               new Select(commandText);
    }

    @Override
    public Transaction createTransaction(Connection connection) {
        return new FastTransaction();
    }
}
