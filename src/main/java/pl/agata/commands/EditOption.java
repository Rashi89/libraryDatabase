package pl.agata.commands;

import pl.agata.controller.BooksController;
import pl.agata.service.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EditOption extends Command {
    public String title;
    public String author;
    public String publisher;
    public int publicationDate;

    public EditOption() {
        super("edit");
    }

    @Override
    public void execute(DBService dbService) throws SQLException {
//        DBService dbService = new DBService();
//        dbService.init();
        int id =0;
        String type="";
        BooksController booksController = new BooksController();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł książki którą chcesz edytować: ");
        title = scanner.nextLine();
        System.out.print("Podaj autora książki którą chcesz edytować: ");
        author = scanner.nextLine();
        System.out.print("Podaj wydawce książki którą chcesz edytować: ");
        publisher = scanner.nextLine();
        System.out.print("Podaj rok wydania książki którą chcesz edytować: ");
        publicationDate = scanner.nextInt();

        int idType = 0;
        dbService.init();
        ResultSet resultSet = dbService.query("SELECT COUNT(title),id,type FROM `books` WHERE title ='"+title+"' " +
                "AND author='"+author+"' AND publication_year="+publicationDate+";");
        while(resultSet.next()){

            int quantity = resultSet.getInt("COUNT(title)");
            if(quantity == 0){
                System.out.println("Nie ma takej pozycji w bazie");
                break;
            }
            else {
                booksController.createAlbum(1, "album", "A", "B", "C", 2022,1);
                booksController.createComic(2, "comics", "A", "B", "C", 2022,1);
                booksController.createFairystyle(3, "fairytale", "A", "B", "C", 2022,1);
                booksController.createGuide(4, "guide", "A", "B", "C", 2022,1);
                booksController.createScience(5, "science", "A", "B", "C", 2022,1);
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
            case "comics":
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
