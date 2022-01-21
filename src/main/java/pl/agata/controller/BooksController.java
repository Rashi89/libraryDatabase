package pl.agata.controller;

import pl.agata.books.*;

import java.util.ArrayList;
import java.util.List;

public class BooksController {
    private final List<Book> books;

    public BooksController() {
        this.books = new ArrayList<>();
    }

    public Book createAlbum(int id, String type, String author, String title, String publisher, int publicationDate){
        Book book = new Albums(id,type,author,title,publisher,publicationDate);
        this.books.add(book);
        return book;
    }

    public Book createComic(int id, String type, String author, String title, String publisher, int publicationDate){
        Book book = new Comics(id,type,author,title,publisher,publicationDate);
        this.books.add(book);
        return book;
    }

    public Book createFairystyle(int id, String type, String author, String title, String publisher, int publicationDate){
        Book book = new Fairytales(id,type,author,title,publisher,publicationDate);
        this.books.add(book);
        return book;
    }

    public Book createGuide(int id, String type, String author, String title, String publisher, int publicationDate){
        Book book = new Guides(id,type,author,title,publisher,publicationDate);
        this.books.add(book);
        return book;
    }

    public Book createScience(int id, String type, String author, String title, String publisher, int publicationDate){
        Book book = new Science(id,type,author,title,publisher,publicationDate);
        this.books.add(book);
        return book;
    }

    public void remove(int id){
        this.books.removeIf(book -> book.getId() == id);
    }

    public Book getBook(String name){
        for(Book book: this.books){
            if(book.getType().equals(name)){
                return book;
            }
        }
        return null;
    }

}
