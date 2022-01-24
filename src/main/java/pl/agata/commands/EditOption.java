package pl.agata.commands;

import pl.agata.controller.BooksController;
import pl.agata.service.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EditOption extends Command {
    public String title;

    public EditOption() {
        super("edit");
    }

    @Override
    public void execute() throws SQLException {

        int id =0;
        String type="";
        BooksController booksController = new BooksController();
        booksController.createAlbum(1, "album", "A", "B", "C", 2022);
        booksController.createComic(1, "comics", "A", "B", "C", 2022);
        booksController.createFairystyle(1, "fairytale", "A", "B", "C", 2022);
        booksController.createGuide(1, "guide", "A", "B", "C", 2022);
        booksController.createScience(1, "science", "A", "B", "C", 2022);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł książki którą chcesz edytować: ");
        title = scanner.nextLine();

        ResultSet resultSet = DBService.query("SELECT COUNT(title),id,type FROM `books` WHERE title ='"+title+"';");
        while(resultSet.next()){
            int quantity = resultSet.getInt("COUNT(title)");
            if(quantity == 0){
                System.out.println("Nie ma takej pozycji w bazie");
                break;
            }
            else {
                id = resultSet.getInt("id");
                type = resultSet.getString("type");
            }
            booksController.getBook(type).setType(type);
            booksController.getBook(type).setId(id);
            booksController.getBook(type).info();
            System.out.println(booksController.getBook(type).updateToBase());
        }
        DBService.dml(booksController.getBook(type).updateToBase());
        System.out.println();
    }
}
