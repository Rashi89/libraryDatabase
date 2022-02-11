package pl.agata.controller;

import pl.agata.commands.*;
import pl.agata.service.DBService;

import java.util.ArrayList;
import java.util.List;

public class CommandController {

    private final List<Command> commands;
    private DBService dbService;

    public CommandController(DBService dbService) {
        this.dbService = dbService;
        this.commands = new ArrayList<>();
    }

    public Command createCreateOption(){
        Command commend = new CreateOption();
        this.commands.add(commend);
        return commend;
    }

    public Command createDeleteOption(){
        Command commend = new DeleteOption();
        this.commands.add(commend);
        return commend;
    }

    public Command createEditOption(){
        Command commend = new EditOption();
        this.commands.add(commend);
        return commend;
    }

    public Command createFindOption(){
        Command commend = new FindOption();
        this.commands.add(commend);
        return commend;
    }

    public Command createHelpOption(){
        Command commend = new HelpOption();
        this.commands.add(commend);
        return commend;
    }

    public Command createNoneOption(){
        Command commend = new CreateOption();
        this.commands.add(commend);
        return commend;
    }

    public Command createHelpBookOption(){
        Command commend = new HelpBooks();
        this.commands.add(commend);
        return commend;
    }

    public void removeOption(String name){
        this.commands.removeIf(commend -> commend.getNameOption().equals(name));
    }

    public Command getOption(String name){
        for(Command command : this.commands){
            if(command.getNameOption().equals(name)) {
                return command;
            }
        }
        return null;
    }


}
