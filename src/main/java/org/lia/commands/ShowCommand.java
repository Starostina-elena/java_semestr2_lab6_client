package org.lia.commands;

import java.io.Serializable;

public class ShowCommand implements Command {
    private static final long serialVersionUID = 1785464768755190753L;


    public String description() {
        return "shows elements in collection";
    }

    public void execute(String[] arguments) {}

}
