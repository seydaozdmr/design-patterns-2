package abstractfactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheapDataAccess implements DataAccess{
    @Override
    public Connection createConnection(String connectionString) {
        if(!isLocalHost(connectionString))
            throw new IllegalArgumentException("Unsupported remote server.");
        return new CheapConnection(getDataBase(connectionString),getUserName(connectionString),getPassword(connectionString));
    }

    @Override
    public Command createCommand(String commandText) {
        return null;
    }

    @Override
    public Transaction createTransaction(Connection connection) {
        return null;
    }

    private String getDataBase (String connectionString){
        return this.valueOf(connectionString,"Initial Catalog","");
    }
    private String getUserName(String connectionString){
        return this.valueOf(connectionString,"UserId","");
    }
    private String getPassword(String connectionString){
        return this.valueOf(connectionString, "Password","");
    }

    private String valueOf(String connectionString, String key, String substitute){
        Matcher matcher = Pattern.compile(key + "=(?<value>[^;]+);").matcher(connectionString);
        return matcher.find() ? matcher.group("value") : substitute;
    }

    private boolean isLocalHost(String connectionString){
        return valueOf(connectionString,"Data Source","localhost").equals("localhost");
    }
}
