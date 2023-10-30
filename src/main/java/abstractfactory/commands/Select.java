package abstractfactory.commands;

import abstractfactory.Command;
import abstractfactory.Transaction;

public class Select implements Command {
    private String command;

    public Select(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public Object execute(Transaction transaction) {
        return 1;
    }
}
