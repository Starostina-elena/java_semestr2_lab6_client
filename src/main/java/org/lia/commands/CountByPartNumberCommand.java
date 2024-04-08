package org.lia.commands;

import java.io.Serializable;

public class CountByPartNumberCommand implements Command, Serializable {

    public String description() {
        return "shows number of element with specified part number. Pattern: count_by_part_number (String)partNumber";
    }

    public void execute(String[] arguments) {}

}
