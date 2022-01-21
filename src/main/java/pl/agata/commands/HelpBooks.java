package pl.agata.commands;

public class HelpBooks extends Command {
    public HelpBooks() {
        super("help");
    }

    @Override
    public void execute() {
        System.out.println("Wpisz 'Album', by dodać nowy album;");
        System.out.println("Wpisz 'Comics', by dodac nowy komiks;");
        System.out.println("Wpisz 'Science', by dodać nową pozycję popularnonaukową;");
        System.out.println("Wpisz 'Fairytale', by dodać nową bajkę dla dzieci;");
        System.out.println("Wpisz 'Guide', by dodać nowy przewodnik;");
        System.out.println("Wpisz 'Exit', by wyjść z menu dodawania nowej pozycji;");
        System.out.println();
    }
}
