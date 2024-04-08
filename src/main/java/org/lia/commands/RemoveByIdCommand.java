package org.lia.commands;

import java.io.Serializable;

public class RemoveByIdCommand implements Command, Serializable {

    public String description() {
        return "removes element from collection by id";
    }

    public void execute(String[] arguments) {}

}
