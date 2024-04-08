package org.lia.commands;

import java.io.Serializable;
import java.util.ArrayDeque;

public class ClearCommand implements Command, Serializable {

    public String description() {
        return "clears collection";
    }

    public void execute(String[] arguments) {}

}
