package abstractfactory;

import java.util.UUID;

public class FastTransaction implements Transaction{
    private UUID id = UUID.randomUUID();


    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public String toString() {
        return "FastTransaction{" +
                "id=" + id +
                '}';
    }
}
