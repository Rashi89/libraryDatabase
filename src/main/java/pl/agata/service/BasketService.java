package pl.agata.service;


import pl.agata.basket.Basket;
import pl.agata.books.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BasketService {
    private Book book;
    private DBService dbService;
    private List<Book> books;
    private Basket basket;
    int id = 0;
    int idType = 0;
    String type = "";
    String title = "";
    String publisher = "";
    String author = "";
    String description = "";
    int publication_year = 0;
    int pages = 0;
    int quantity = 0;
    int bookQuantity = 0;

    public BasketService(DBService dbService) {
        this.dbService = dbService;
        this.books = new ArrayList<>();
    }

    public List<Book> addBookToBasket(int idUser,int idBook) throws SQLException {
        this.basket = new Basket(idBook,idUser);

        dbService.dml("INSERT INTO `book_orders` (`id`,`id_basket`,`id_book`) VALUES (NULL,"+basket.getIdUser()+","+basket.getIdBook()+");");

            ResultSet result = dbService.query("SELECT b.id,b.type,b.title,b.author,b.publisher,b.publication_year,b.pages,b.quantity,b.description FROM `book_orders` bo INNER JOIN `books` b ON bo.id_book = b.id INNER JOIN `baskets` ba ON ba.id = bo.id_basket INNER JOIN `users` u ON u.id=ba.id_user WHERE u.id="+idUser);
            while (result.next()) {
                id = result.getInt("id");
                type = result.getString("type");
                title = result.getString("title");
                publisher = result.getString("publisher");
                publication_year = result.getInt("publication_year");
                pages = result.getInt("pages");
                bookQuantity = result.getInt("quantity");
                author = result.getString("author");
                description = result.getString("description");
                idType = convertTypeToInt(type);
                book = new Book();
                book.setInformation(id, type, author, title, publisher, publication_year, pages, bookQuantity,description);
                this.books.add(book);
            }
        dbService.closeStatement();

        return books;
    }

    public List<Book> getBasket(int idUser) throws SQLException {
        ResultSet result = dbService.query("SELECT b.id,b.type,b.title,b.author,b.publisher,b.publication_year,b.pages,b.quantity,b.description FROM `book_orders` bo INNER JOIN `books` b ON bo.id_book = b.id INNER JOIN `baskets` ba ON ba.id = bo.id_basket INNER JOIN `users` u ON u.id=ba.id_user WHERE u.id="+idUser);
        while (result.next()) {
            id = result.getInt("id");
            type = result.getString("type");
            title = result.getString("title");
            publisher = result.getString("publisher");
            publication_year = result.getInt("publication_year");
            pages = result.getInt("pages");
            bookQuantity = result.getInt("quantity");
            author = result.getString("author");
            description = result.getString("description");
            idType = convertTypeToInt(type);
            book = new Book();
            book.setInformation(id, type, author, title, publisher, publication_year, pages, bookQuantity,description);
            this.books.add(book);
        }
        dbService.closeStatement();
        return books;
    }

    public int getBasketSize(int idUser) throws SQLException {
        int quantity =0;

        ResultSet result = dbService.query("SELECT COUNT(*) FROM `book_orders` bo INNER JOIN `baskets` b ON bo.id_basket = b.id_user WHERE b.id_user="+idUser);
        while (result.next()) {
           quantity = result.getInt("COUNT(*)");
        }
        dbService.closeStatement();
        return quantity;

    }

    public void deleteBasket(int id) throws SQLException {

        dbService.dml("DELETE bo.* FROM `book_orders` bo INNER JOIN `books` b ON bo.id_book = b.id INNER JOIN `baskets` ba ON ba.id = bo.id_basket INNER JOIN `users` u ON u.id=ba.id_user WHERE u.id="+id);
        dbService.closeStatement();
    }

    public void addBasketToRental(int idUser, int idBook) throws SQLException {
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(7);
        int quantity = 0;
        ResultSet resultSet = dbService.query("SELECT `quantity` FROM `books` WHERE id ="+idBook);
        while(resultSet.next()){
            quantity = resultSet.getInt("quantity")-1;
        }

        dbService.dml("UPDATE `books` SET `quantity`="+quantity+" WHERE id ="+idBook);

        dbService.dml("INSERT INTO `rentals`(`id`, `start`, `end`, `id_user`, `id_book`, `comments`) VALUES (NULL,'" + start + "','" + end + "'," + idUser + "," + idBook + ",'')");
        dbService.closeStatement();

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
