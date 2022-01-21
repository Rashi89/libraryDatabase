package pl.agata.commands;

public class NoneOption extends Command {
    public NoneOption() {
        super("none");
    }

    @Override
    public void execute() {
        System.out.println("Nie ma takiej opcji w menu.");
        System.out.println("Wpisz 'help' jeśli chcesz uzyskać pomoc.");
        System.out.println();
    }
}
