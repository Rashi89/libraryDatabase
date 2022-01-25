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
        DBService dbService = new DBService();
        dbService.init();
        int id =0;
        String type="";
        BooksController booksController = new BooksController();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł książki którą chcesz edytować: ");
        title = scanner.nextLine();
        int idType = 0;
        ResultSet resultSet = dbService.query("SELECT COUNT(title),id,type FROM `books` WHERE title ='"+title+"';");
        while(resultSet.next()){

            int quantity = resultSet.getInt("COUNT(title)");
            if(quantity == 0){
                System.out.println("Nie ma takej pozycji w bazie");
                break;
            }
            else {
                booksController.createAlbum(1, "album", "A", "B", "C", 2022);
                booksController.createComic(2, "comics", "A", "B", "C", 2022);
                booksController.createFairystyle(3, "fairytale", "A", "B", "C", 2022);
                booksController.createGuide(4, "guide", "A", "B", "C", 2022);
                booksController.createScience(5, "science", "A", "B", "C", 2022);
                id = resultSet.getInt("id");
                type = resultSet.getString("type");
                idType = convertTypeToInt(type);
                booksController.getBook(idType).setType(type);
                booksController.getBook(idType).info();
                booksController.getBook(idType).setId(id);
            }

        }
        dbService.dml(booksController.getBook(id).updateToBase());
        System.out.println();
    }

    private int convertTypeToInt(String type){
        switch(type){
            case "album":
                return 1;
            case "comic":
                return 2;
            case "fairytale":
                return 3;
            case "guide":
                return 4;
            case "science":
                return 5;
            default:
                return 0;
        }
    }
}
