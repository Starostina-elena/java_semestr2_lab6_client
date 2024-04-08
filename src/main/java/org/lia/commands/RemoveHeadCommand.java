package org.lia.commands;


import java.io.Serializable;

public class RemoveHeadCommand implements Command {
    private static final long serialVersionUID = 1785464768755190753L;


    public String description() {
        return "shows first element of collection and deletes it";
    }

    public void execute(String[] arguments) {}

}
