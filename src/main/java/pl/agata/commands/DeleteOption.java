package pl.agata.commands;

public class DeleteOption extends Command {

    public DeleteOption() {
        super("delete");
    }

    @Override
    public void execute() {
        System.out.println("Deleting...");
        System.out.println();
    }
}
