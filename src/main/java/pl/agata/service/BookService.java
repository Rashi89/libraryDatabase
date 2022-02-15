package pl.agata.service;

import pl.agata.books.Book;
import pl.agata.rental.Rental;
import pl.agata.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        dbService.closeStatement();

    }

    public Book getBookInformationById(int id) throws SQLException {
        int idType = 0;
        String type = "";
        String title = "";
        String publisher = "";
        String author="";
        int publication_year = 0;
        int pages = 0;
        int quantity = 0;
        int bookQuantity =0;
        String description ="";

        ResultSet resultSet = dbService.query("SELECT * FROM `books` b WHERE b.id="+id);
        while(resultSet.next()){
            id = resultSet.getInt("id");
            type = resultSet.getString("type");
            title = resultSet.getString("title");
            publisher = resultSet.getString("publisher");
            publication_year = resultSet.getInt("publication_year");
            pages = resultSet.getInt("pages");
            bookQuantity = resultSet.getInt("quantity");
            author = resultSet.getString("author");
            description =resultSet.getString("description");
            idType = convertTypeToInt(type);
            book = new Book();
            book.setInformation(id,type,author,title,publisher,publication_year,pages,bookQuantity,description);
        }
        dbService.closeStatement();
        return book;
    }

    public List<Book> getBooksLimit(int limit) throws SQLException {
        int id =0;
        int idType = 0;
        String type = "";
        String title = "";
        String publisher = "";
        String author="";
        int publication_year = 0;
        int pages = 0;
        int quantity = 0;
        int bookQuantity =0;
        String description ="";
        int quantityOffset = 12;
        books.clear();
        ResultSet resultSet = dbService.query("SELECT * FROM `books` b LIMIT 12 OFFSET "+quantityOffset*limit);
        while(resultSet.next()){
            id = resultSet.getInt("id");
            type = resultSet.getString("type");
            title = resultSet.getString("title");
            publisher = resultSet.getString("publisher");
            publication_year = resultSet.getInt("publication_year");
            pages = resultSet.getInt("pages");
            bookQuantity = resultSet.getInt("quantity");
            author = resultSet.getString("author");
            description =resultSet.getString("description");
            idType = convertTypeToInt(type);
            book = new Book();
            book.setInformation(id,type,author,title,publisher,publication_year,pages,bookQuantity,description);
            this.books.add(book);
        }
        dbService.closeStatement();
        return books;
    }

    public List<Book> addBook() throws SQLException {
        int id =0;
        int idType = 0;
        String type = "";
        String title = "";
        String publisher = "";
        String author="";
        int publication_year = 0;
        int pages = 0;
        int quantity = 0;
        int bookQuantity =0;
        String description ="";
        books.clear();
        ResultSet resultSet = dbService.query("SELECT * FROM `books` b");
        while(resultSet.next()){
            id = resultSet.getInt("id");
            type = resultSet.getString("type");
            title = resultSet.getString("title");
            publisher = resultSet.getString("publisher");
            publication_year = resultSet.getInt("publication_year");
            pages = resultSet.getInt("pages");
            bookQuantity = resultSet.getInt("quantity");
            author = resultSet.getString("author");
            description =resultSet.getString("description");
            idType = convertTypeToInt(type);
            book = new Book();
            book.setInformation(id,type,author,title,publisher,publication_year,pages,bookQuantity,description);
            this.books.add(book);
        }
        dbService.closeStatement();
        return books;
    }

    public int quantityPagesAllBook() throws SQLException {
        int quantity = 0;
        int licznik = 1;
        ResultSet resultSet = dbService.query("SELECT COUNT(*) FROM `books` b");
        while(resultSet.next()){
            quantity = resultSet.getInt("COUNT(*)");
        }
        dbService.closeStatement();
        while(quantity-12>0)
        {
            licznik = licznik+1;
            quantity = quantity-12;
        }
        return licznik;
    }

    public int quantityPagesSearchBook(String str) throws SQLException {
        int quantity = 0;
        int licznik = 1;
        ResultSet resultSet = dbService.query("SELECT COUNT(*) FROM `books` b WHERE b.title LIKE '%"+str+"%'");
        while(resultSet.next()){
            quantity = resultSet.getInt("COUNT(*)");
        }
        dbService.closeStatement();
        while(quantity-12>0)
        {
            licznik = licznik+1;
            quantity = quantity-12;
        }
        return licznik;
    }

    public List<Book> searchBook(String str,int limit) throws SQLException {
        int id =0;
        int idType = 0;
        String type = "";
        String title = "";
        String publisher = "";
        String author="";
        int publication_year = 0;
        int pages = 0;
        int quantity = 0;
        int bookQuantity =0;
        String description ="";
        int quantityOffset = 12;

        ResultSet resultSet = dbService.query("SELECT * FROM `books` b WHERE b.title LIKE '%"+str+"%' LIMIT 12 OFFSET "+quantityOffset*limit);
        while(resultSet.next()){
            id = resultSet.getInt("id");
            type = resultSet.getString("type");
            title = resultSet.getString("title");
            publisher = resultSet.getString("publisher");
            publication_year = resultSet.getInt("publication_year");
            pages = resultSet.getInt("pages");
            bookQuantity = resultSet.getInt("quantity");
            author = resultSet.getString("author");
            description =resultSet.getString("description");
            idType = convertTypeToInt(type);
            book = new Book();
            book.setInformation(id,type,author,title,publisher,publication_year,pages,bookQuantity,description);
            this.books.add(book);
        }
        dbService.closeStatement();
        return books;
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
