package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashMap;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "publishedYear", nullable = false)
    private int publishedYear;

    @Column(name = "numberPages", nullable = false)
    private int numberPages;

    @Column(name = "authorNames", length = 100, nullable = false)
    private String authorNames;

    @JsonCreator
    public Book(long id, String title, String description, long price, int publishedYear, int numberPages, String authorNames) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.publishedYear = publishedYear;
        this.numberPages = numberPages;
        this.authorNames = authorNames;
    }

    public Book() {

    }

    public String CreateBookCard() {
        return "The book " + this.title + " has been written by " + this.authorNames+ " and was published in " + this.publishedYear + ". The book's price is " + this.price;
    }

    public HashMap<String, String> getDetails() {
        HashMap<String, String> details = new HashMap<>();
        details.put("title", this.title); // The statement does not ask for it, but we consider it is necessary
        details.put("description", this.description);
        details.put("price", Long.toString(this.price));
        details.put("publishedYear", Long.toString(this.publishedYear));
        details.put("numberPages", Long.toString(this.numberPages));
        return details;
    }

    public HashMap<String, String> getAuthorDetails() {
        HashMap<String, String> details = new HashMap<>();
        details.put("title", this.title);
        details.put("authorNames", this.authorNames);
        return details;
    }

    public long getId() {
        return this.id;
    }

    public boolean validateTitle() {
        return (this.title.length() < 5 || this.title.length() > 100) ? false : true;
    }

    public boolean validateDescription() {
        return (this.description.length() > 200) ? false : true;
    }

    public boolean validatePrice() {
        return (this.price < 10000) ? false : true;
    }

    public boolean validateAuthorNames() {
        return ((this.authorNames.split(" ").length < 2) || this.authorNames.length() > 100) ? false : true;
    }

    public boolean validatePublishedYear() {
        Calendar currentCalendar = Calendar.getInstance();
        return (Integer.toString(this.publishedYear).length() != 4 || this.publishedYear > currentCalendar.get(Calendar.YEAR)) ? false : true;
    }

    public boolean validateNumberPages() {
        return (this.numberPages > 1500 || this.numberPages < 1) ? false : true;
    }

}
