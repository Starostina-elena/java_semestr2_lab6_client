package org.lia.commands;


public class RemoveByIdCommand implements Command {
    private static final long serialVersionUID = 1785464768755190753L;

    private long id;

    public String description() {
        return "removes element from collection by id";
    }

    public void execute(String[] arguments) {
        id = Integer.parseInt(arguments[1]);
    }

}
