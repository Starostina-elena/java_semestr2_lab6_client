package org.lia.commands;

import java.io.Serializable;

public class InfoCommand implements Command, Serializable {

    public String description() {
        return "shows short information on collection";
    }

    public void execute(String[] arguments) {}

}
