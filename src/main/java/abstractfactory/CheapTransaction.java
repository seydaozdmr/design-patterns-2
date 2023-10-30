package abstractfactory;

public class CheapTransaction implements Transaction{
    private int transactionId;
    private CheapConnection connection;

    public CheapTransaction(CheapConnection connection){
        this.connection = connection;
        this.transactionId = (int)connection.sendCommand("BEGIN TRANSACTION");
    }


    @Override
    public void commit() {
        this.connection.sendCommand("COMMIT TRANSACTION");
    }

    @Override
    public void rollback() {
        this.connection.sendCommand("ROLLBACK TRANSACTION");
    }

    @Override
    public String toString() {
        return "CheapTransaction{" +
                "transactionId=" + transactionId +
                '}';
    }
}
