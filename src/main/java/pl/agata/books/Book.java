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

    protected Book(int id, String type, String author, String title, String publisher, int publicationDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.type = type;
        this.publicationDate = publicationDate;
    }

    public void info(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj autora książki: ");
        setAuthor(scanner.nextLine());
        System.out.print("Podaj tytuł książki: ");
        setTitle(scanner.nextLine());
        System.out.print("Podaj wydawcę książki: ");
        setPublisher(scanner.nextLine());
        validatePublicationDate();
    }

    public String addToBase(){
        String string = "INSERT INTO books (`id`, `type`, `title`, `author`, `publisher`, `publication_year`) " +
                "VALUES('"+id+"','"+type+"','"+title+"','"+author+"','"+publisher+"',"+publicationDate+")";
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
