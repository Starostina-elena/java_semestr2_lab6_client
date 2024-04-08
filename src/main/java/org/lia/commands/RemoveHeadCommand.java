package org.lia.commands;


import java.io.Serializable;

public class RemoveHeadCommand implements Command, Serializable {

    public String description() {
        return "shows first element of collection and deletes it";
    }

    public void execute(String[] arguments) {}

}
