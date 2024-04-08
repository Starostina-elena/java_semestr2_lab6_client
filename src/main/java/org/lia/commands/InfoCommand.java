package org.lia.commands;

import java.io.Serializable;

public class InfoCommand implements Command {
    private static final long serialVersionUID = 1785464768755190753L;

    public String description() {
        return "shows short information on collection";
    }

    public void execute(String[] arguments) {}

}
