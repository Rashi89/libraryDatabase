package pl.agata.books;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Book {

    protected int id;
    protected String author;
    protected String title;
    protected String publisher;
    protected String type;
    protected static int publicationDate;
    protected int quantity;

    protected Book(int id, String type, String author, String title, String publisher, int publicationDate, int quantity) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.type = type;
        this.publicationDate = publicationDate;
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void info(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj autora książki: ");
        setAuthor(scanner.nextLine());
        System.out.print("Podaj tytuł książki: ");
        setTitle(scanner.nextLine());
        System.out.print("Podaj wydawcę książki: ");
        setPublisher(scanner.nextLine());
        validateQuantityBook();
        validatePublicationDate();
    }

    public String addToBase(){
        String string = "INSERT INTO books (`id`, `type`, `title`, `author`, `publisher`, `publication_year`, `quantity`) " +
                "VALUES('"+id+"','"+type+"','"+title+"','"+author+"','"+publisher+"',"+publicationDate+","+quantity+");";
        return string;
    }

    public String updateToBase(){
        String string = "UPDATE books SET type='"+type+"', title='"+title+"', author='"+author+"', publisher='"+
                publisher+"',publication_year="+publicationDate+",quantity="+quantity+" WHERE id="+id;
        return string;
    }

    private void validatePublicationDate() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj rok wydania książki: ");
            publicationDate = scanner.nextInt();
            if (publicationDate < 0) {
                throw new IllegalArgumentException();
            }
            else {
                setPublicationDate(publicationDate);
            }
        } catch (InputMismatchException e) {
            System.out.println("Podaj liczbę całkowitą!");
            validatePublicationDate();
        } catch (IllegalArgumentException e) {
            System.out.println("Podaj liczbę całkowitą dodatnią!");
            validatePublicationDate();
        }
    }
    private void validateQuantityBook(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj ilość egzemplarzy: ");
            quantity = scanner.nextInt();
            if (quantity < 0) {
                throw new IllegalArgumentException();
            }
            else {
                setQuantity(quantity);
            }
        } catch (InputMismatchException e) {
            System.out.println("Podaj liczbę całkowitą!");
            validateQuantityBook();
        } catch (IllegalArgumentException e) {
            System.out.println("Podaj liczbę całkowitą dodatnią!");
            validateQuantityBook();
        }
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setInformation(int id, String type, String author, String title, String publisher, int publicationDate, int pages, int quantity){
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.type = type;
        this.publicationDate = publicationDate;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +'\''+
                ", quantity="+quantity+
                '}';
    }
}
