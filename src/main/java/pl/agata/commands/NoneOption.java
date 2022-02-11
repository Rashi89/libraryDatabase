package pl.agata.commands;

import pl.agata.service.DBService;

public class NoneOption extends Command {
    public NoneOption() {
        super("none");
    }

    @Override
    public void execute(DBService dbService) {
        System.out.println("Nie ma takiej opcji w menu.");
        System.out.println("Wpisz 'help' jeśli chcesz uzyskać pomoc.");
        System.out.println();
    }
}
