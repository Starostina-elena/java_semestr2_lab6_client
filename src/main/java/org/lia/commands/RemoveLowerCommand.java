package org.lia.commands;

import java.io.Serializable;

public class RemoveLowerCommand implements Command, Serializable {

    public String description() {
        return "delete from collection all elements lower that selected. Pattern: remove_lower (long)id";
    }

    public void execute(String[] arguments) {}

}
