package pl.agata.commands;

import pl.agata.controller.BooksController;
import pl.agata.controller.CommandController;
import pl.agata.service.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class CreateOption extends Command {

    private static String type;

    public CreateOption() {
        super("create");
    }

    @Override
    public void execute(DBService dbService) throws SQLException {
        boolean run = true;
        while (run) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj typ książki: ");
            type = scanner.nextLine().toLowerCase(Locale.ROOT);
            int id =0;
            int idType = convertTypeToInt(type);
            BooksController booksController = new BooksController();
            CommandController commandController = new CommandController(dbService);
            commandController.createHelpBookOption();
            booksController.createAlbum(1, "album", "A", "B", "C", 2022,1,"");
            booksController.createComic(2, "comics", "A", "B", "C", 2022,1,"");
            booksController.createFairystyle(3, "fairytale", "A", "B", "C", 2022,1,"");
            booksController.createGuide(4, "guide", "A", "B", "C", 2022,1,"");
            booksController.createScience(5, "science", "A", "B", "C", 2022,1,"");

            if(!type.equals("exit")&&!type.equals("help")) {
                try{
                    booksController.getBook(idType);
                    booksController.getBook(idType).info();
                    ResultSet resultSet = dbService.query("SELECT MAX(id) FROM `books`;");
                    while(resultSet.next()){
                        id = resultSet.getInt("MAX(id)")+1;
                        booksController.getBook(idType).setId(id);
                    }
                    dbService.dml(booksController.getBook(id).addToBase());
                    run = false;
                } catch(NullPointerException e){
                    System.out.println("Wpisz 'help' jeśli chcesz uzyskać pomoc.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if(type.equals("help")){
                try{
                    commandController.getOption(type);
                    commandController.getOption(type).execute(dbService);
                } catch (NullPointerException e){
                    System.out.println("Coś poszło nie tak!");
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if(type.equals("exit")){
                run = false;
            }
        }
    }
}
