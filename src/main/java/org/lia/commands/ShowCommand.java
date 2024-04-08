package org.lia.commands;

import java.io.Serializable;

public class ShowCommand implements Command, Serializable {

    public String description() {
        return "shows elements in collection";
    }

    public void execute(String[] arguments) {}

}
