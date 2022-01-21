package pl.agata.commands;

public class EditOption extends Command {
    public EditOption() {
        super("edit");
    }

    @Override
    public void execute() {
        System.out.println("Editing...");
        System.out.println();
    }
}
