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
        DBService dbService = new DBService();
        dbService.init();
        int id=0;
        String type="";
        int quantity = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tytuł książki do usunięcia: ");
        title = scanner.nextLine();

        ResultSet resultSet = dbService.query("SELECT COUNT(title) FROM `books` WHERE title ='"+title+"';");
        while(resultSet.next()){
            quantity = resultSet.getInt("COUNT(title)");
            if(quantity == 0){
                System.out.println("Nie ma takej pozycji w bazie");
                break;
            }
        }
        resultSet.close();
        if(quantity!=0){
            for(int i=0; i<quantity;i++) {
                ResultSet resultSetId = dbService.query(("SELECT id FROM `books` WHERE title ='" + title + "';"));
                while (resultSetId.next()) {
                    id = resultSetId.getInt("id");
                }
                dbService.dml(booksController.removeToBase(id));
                resultSetId.close();
            }
        }
        System.out.println();
    }
}
