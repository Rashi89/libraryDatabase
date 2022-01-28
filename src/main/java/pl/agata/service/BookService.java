package pl.agata.service;

import pl.agata.books.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private Book book;
    private DBService dbService;
    private List<Book> books;

    public BookService(DBService dbService) {
        this.dbService = dbService;
        this.books = new ArrayList<>();
    }

    public void showInfo() throws SQLException {
        int year = 0;
        String monthName = "";
        int quantity = 0;
        String number ="";
        dbService.init();
        ResultSet resultSet = dbService.query("SELECT YEAR(r.start) year,MONTHNAME(r.start) month, COUNT(*) quantity " +
                "FROM rentals r GROUP BY YEAR(r.start),MONTHNAME(r.start) WITH ROLLUP");
        while(resultSet.next()){
            year=resultSet.getInt("year");
            monthName=resultSet.getString("month");
            quantity=resultSet.getInt("quantity");
            if(quantity == 1){
                number ="książkę";
            } else {
                number = "książek";
            }
            if(year != 0 && monthName != null) {
                System.out.println("Rok: " + year + ", miesiąc: " + monthName + ", ilosc egzemplarzy: " + quantity);
            } else if(year != 0 && monthName == null){
                System.out.println("W roku " + year + " wypożyczono " + quantity+" "+number);
            } else if(year == 0 && monthName == null){
                System.out.println("W sumie wypożyczono " + quantity+" "+number);
            }
        }
    }

}
