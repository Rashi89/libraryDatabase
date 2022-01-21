package pl.agata.commands;

public class HelpOption extends Command {
    public HelpOption() {
        super("help");
    }

    @Override
    public void execute() {
        System.out.println("Wpisz 'Create', by dodać nową pozycję;");
        System.out.println("Wpisz 'Find', by wyszukać pozycję;");
        System.out.println("Wpisz 'Edit', by edytować pozycję;");
        System.out.println("Wpisz 'Delete', by usunąć pozycję;");
        System.out.println("Wpisz 'Exit', by wyjść;");
        System.out.println();
    }
}
