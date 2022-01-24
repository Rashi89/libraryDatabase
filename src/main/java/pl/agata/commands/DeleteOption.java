package pl.agata.commands;

import pl.agata.controller.BooksController;
import pl.agata.service.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteOption extends Command {

    public String title;

    public DeleteOption() {
        super("delete");
    }

    @Override
    public void execute() throws SQLException {
        BooksController booksController = new BooksController();
        int id=0;
        String type="";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł książki do usunięcia: ");
        title = scanner.nextLine();

        ResultSet resultSet = DBService.query("SELECT COUNT(title),id, type FROM `books` WHERE title ='"+title+"';");
        while(resultSet.next()){
            int quantity = resultSet.getInt("COUNT(title)");
            if(quantity == 0){
                System.out.println("Nie ma takej pozycji w bazie");
                break;
            }
            else {
                id = resultSet.getInt("id");
                type = resultSet.getString("type");

                System.out.println(type);
            }
            System.out.println("aga");
            System.out.println(id);

        }
        DBService.dml(booksController.removeToBase(id));

        System.out.println();
    }
}
