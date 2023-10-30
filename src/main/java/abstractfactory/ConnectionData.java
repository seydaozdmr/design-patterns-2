package abstractfactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConnectionData {
    private static final String SERVER_KEY = "localhost";
    private static final String DATABASE_KEY = "test";
    private static final String USER_NAME_KEY = "user";
    private static final String PASSWORD_KEY = "password";
    private Map<String,String> keyValues;

    public ConnectionData(String connectionData) {
        this.keyValues = Arrays.stream(connectionData.split(";")).map(pair -> pair.split("=",2)).collect(HashMap::new, (map,pair) -> map.put(pair[0],pair[1]),HashMap::putAll);
        List<String> supportedKeys = Arrays.asList (this.SERVER_KEY,this.DATABASE_KEY,this.USER_NAME_KEY,this.PASSWORD_KEY);
        if(!this.keyValues.keySet().stream().allMatch(supportedKeys::contains))
            throw new IllegalArgumentException("Not all keys are supported");
    }

    public String getServer(){
        return this.keyValues.getOrDefault(SERVER_KEY,"localhost");
    }
    public String getDatabase(){
        return this.keyValues.getOrDefault(DATABASE_KEY,"test");
    }

    public Credentials getCredentials(){
        return new UserCredential(this.getUserName(),this.getPassword());
    }

    private String getUserName(){
        return this.keyValues.get(USER_NAME_KEY);
    }

    private String getPassword(){
        return this.keyValues.get(PASSWORD_KEY);
    }


}
