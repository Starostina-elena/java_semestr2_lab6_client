package org.lia.commands;

import java.io.Serializable;

public class MinByIdCommand implements Command {
    private static final long serialVersionUID = 1785464768755190753L;


    public String description() {
        return "shows element with min id";
    }

    public void execute(String[] arguments) {}

}
