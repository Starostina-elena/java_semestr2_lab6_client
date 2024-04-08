package org.lia.commands;

import java.io.Serializable;

public class MinByIdCommand implements Command, Serializable {

    public String description() {
        return "shows element with min id";
    }

    public void execute(String[] arguments) {}

}
