package pl.agata.books;

public class Comics extends Book{
    public Comics(int id, String type, String author, String title, String publisher, int publicationDate,int quantity) {
        super(id, type, author, title, publisher, publicationDate,quantity);
    }

    @Override
    public void info() {
        super.info();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
