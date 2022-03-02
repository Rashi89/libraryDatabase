package pl.agata.commands;

import pl.agata.controller.BooksController;
import pl.agata.service.DBService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindOption extends Command {

    private static String option;

    public FindOption() {
        super("find");
    }

    @Override
    public void execute(DBService dbService) throws SQLException {
        BooksController booksController = new BooksController();
        int id =0;
        int idType = 0;
        String type = "";
        String title = "";
        String publisher = "";
        int publication_year = 0;
        int pages = 0;
        int quantity = 0;
        int bookQuantity =0;
        String description ="";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj autora: ");
        option = scanner.nextLine();

        ResultSet resultSet = dbService.query("SELECT COUNT(author) FROM `books` WHERE author ='"+option+"';");

        while(resultSet.next()) {
            quantity = resultSet.getInt("COUNT(author)");
            if (quantity == 0) {
                System.out.println("Nie ma takego autora w bazie");
                break;
            }
        }
        if(quantity!=0)
             {
                ResultSet resultSetInfo = dbService.query("SELECT id, type, title, publisher, publication_year, pages,quantity,description FROM `books` WHERE author ='"+option+"';");
                while(resultSetInfo.next()){
                    booksController.createAlbum(1, "album", "A", "B", "C", 2022,1,"");
                    booksController.createComic(2, "comics", "A", "B", "C", 2022,1,"");
                    booksController.createFairystyle(3, "fairytale", "A", "B", "C", 2022,1,"");
                    booksController.createGuide(4, "guide", "A", "B", "C", 2022,1,"");
                    booksController.createScience(5, "science", "A", "B", "C", 2022,1,"");

                    id = resultSetInfo.getInt("id");
                    type = resultSetInfo.getString("type");
                    title = resultSetInfo.getString("title");
                    publisher = resultSetInfo.getString("publisher");
                    publication_year = resultSetInfo.getInt("publication_year");
                    pages = resultSetInfo.getInt("pages");
                    bookQuantity = resultSetInfo.getInt("quantity");
                    description = resultSetInfo.getString("description");
                    idType = convertTypeToInt(type);

                    booksController.getBook(idType).setInformation(id,type,option,title,publisher,publication_year,pages,bookQuantity,description);
                    System.out.println(booksController.getBook(id).toString());
                }
            }
        System.out.println();
    }
}
