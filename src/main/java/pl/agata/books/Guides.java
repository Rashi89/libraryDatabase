package pl.agata.books;

public class Guides extends Book{
    public Guides(int id, String type, String author, String title, String publisher, int publicationDate,int quantity,String description) {
        super(id, type, author, title, publisher, publicationDate,quantity,description);
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
