package pl.agata.commands;

import pl.agata.service.DBService;

import java.sql.SQLException;

public abstract class Command {

    protected String nameOption;
    private DBService dbService;

    public Command(String nameOption) {
        this.nameOption = nameOption;
    }

    public abstract void execute(DBService dbService) throws SQLException;

    public String getNameOption() {
        return nameOption;
    }
}
