package pl.agata.commands;

public abstract class Command {

    protected String nameOption;

    public Command(String nameOption) {
        this.nameOption = nameOption;
    }

    public abstract void execute();

    public String getNameOption() {
        return nameOption;
    }
}
