package pl.agata.rental;

import java.util.Date;

public class Rental {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Rental(String title, String author, Date startDate, Date endDate) {
        this.title = title;
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private String title;
    private String author;
    private Date startDate;
    private Date endDate;
}
