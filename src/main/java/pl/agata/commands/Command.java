package pl.agata.commands;

import java.sql.SQLException;

public abstract class Command {

    protected String nameOption;

    public Command(String nameOption) {
        this.nameOption = nameOption;
    }

    public abstract void execute() throws SQLException;

    public String getNameOption() {
        return nameOption;
    }
}
