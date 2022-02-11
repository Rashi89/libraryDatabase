package pl.agata.basket;

public class Basket {

    private int id;
    private int idBook;
    private int idUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Basket(int idBook, int idUser) {
        this.id = id;
        this.idBook = idBook;
        this.idUser = idUser;
    }
}
