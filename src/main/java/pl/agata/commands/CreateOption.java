package pl.agata.commands;

import pl.agata.controller.BooksController;
import pl.agata.controller.CommandController;

import java.util.Locale;
import java.util.Scanner;

public class CreateOption extends Command {

    private static String type;

    public CreateOption() {
        super("create");
    }

    @Override
    public void execute() {
        boolean run = true;
        while (run) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj typ książki: ");
            type = scanner.nextLine().toLowerCase(Locale.ROOT);

            BooksController booksController = new BooksController();
            CommandController commandController = new CommandController();
            commandController.createHelpBookOption();
            booksController.createAlbum(1, "album", "A", "B", "C", 2022);
            booksController.createComic(1, "comics", "A", "B", "C", 2022);
            booksController.createFairystyle(1, "fairytale", "A", "B", "C", 2022);
            booksController.createGuide(1, "guide", "A", "B", "C", 2022);
            booksController.createScience(1, "science", "A", "B", "C", 2022);

            if(!type.equals("exit")&&!type.equals("help")) {
                try{
                    booksController.getBook(type);
                    booksController.getBook(type).info();
                    System.out.println(booksController.getBook(type).toString());
                } catch(NullPointerException e){
                    System.out.println("Wpisz 'help' jeśli chcesz uzyskać pomoc.");
                }
            }
            else if(type.equals("help")){
                try{
                    commandController.getOption(type);
                    commandController.getOption(type).execute();
                } catch (NullPointerException e){
                    System.out.println("Coś poszło nie tak!");
                }
            }
            else if(type.equals("exit")){
                run = false;
            }
        }
    }
}
