package pl.agata.commands;

public class FindOption extends Command {
    public FindOption() {
        super("find");
    }

    @Override
    public void execute() {
        System.out.println("Finding...");
        System.out.println();
    }
}
