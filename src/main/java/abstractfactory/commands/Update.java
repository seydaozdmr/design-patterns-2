package abstractfactory.commands;

import abstractfactory.Command;
import abstractfactory.Transaction;

public class Update implements Command {
    private String command;

    public Update(String command) {
        this.command = command;
    }

    public String getCommand(){
        return this.command;
    }

    @Override
    public Object execute(Transaction transaction) {
        return 5;
    }
}
