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

    public int convertTypeToInt(String type){
        switch(type){
            case "album":
                return 1;
            case "comics":
                return 2;
            case "fairytale":
                return 3;
            case "guide":
                return 4;
            case "science":
                return 5;
            default:
                return 0;
        }
    }
}
