package abstractfactory.commands;

import abstractfactory.Command;
import abstractfactory.Transaction;

public class Insert implements Command {
    private String command;

    public Insert(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public Object execute(Transaction transaction) {
        return 17;
    }
}
