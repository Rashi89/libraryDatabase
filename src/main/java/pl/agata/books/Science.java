package pl.agata.books;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Science extends Book{

    private int numberOfPages;

    public Science(int id,String type, String author, String title, String publisher, int publicationDate,int quantity) {
        super(id, type, author, title, publisher, publicationDate,quantity);
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void info(){
        super.info();
        validateNumberOfPages();
    }

    private void validateNumberOfPages() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj ilość stron książki: ");
            numberOfPages = scanner.nextInt();
            if (numberOfPages < 0) {
                throw new IllegalArgumentException();
            }
            else {
                setNumberOfPages(numberOfPages);
            }
        } catch (InputMismatchException e) {
            System.out.println("Podaj liczbę całkowitą!");
            validateNumberOfPages();
        } catch (IllegalArgumentException e) {
            System.out.println("Podaj liczbę całkowitą dodatnią!");
            validateNumberOfPages();
        }
    }

    @Override
    public String addToBase(){
        String string = "INSERT INTO books (`id`, `type`, `title`, `author`, `publisher`, `publication_year`,`pages` ) " +
                "VALUES('"+id+"','"+type+"','"+title+"','"+author+"','"+publisher+"',"+publicationDate+","+numberOfPages+")";
        return string;
    }

    @Override
    public void setInformation(int id, String type, String author, String title, String publisher, int publicationDate,int pages,int quantity){
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.type = type;
        this.publicationDate = publicationDate;
        this.quantity = quantity;
        setNumberOfPages(pages);
    }

    @Override
    public String toString() {
        return "Science{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +'\''+
                ", quantity=" + quantity +'\''+
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
