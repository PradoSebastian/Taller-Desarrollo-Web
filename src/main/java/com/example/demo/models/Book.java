package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private long id;

    //@Size(min = 5, max = 100, message = "The title must be between 5 and 100 characters")
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    //@Size(max = 200, message = "The description must be less than 200 characters")
    @Column(name = "description", length = 200, nullable = false)
    private String description;

    //@Min(value = 10000, message = "Price should not be less than 10000 pesos")
    @Column(name = "price", nullable = false)
    private long price;

    //@Min(value = 1000, message = "The publishedYear must be exactly 4 characters")
    //@Max(value = 9999, message = "The publishedYear must be exactly 4 characters")
    @Column(name = "publishedYear", nullable = false)
    private int publishedYear;

    //@Min(value = 1, message = "NumberPages should not be less than 1")
    //@Max(value = 1500, message = "NumberPages should not be greater than 1500")
    @Column(name = "numberPages", nullable = false)
    private int numberPages;

    //@Size(max = 100, message = "The authorNames must be less than 100 characters")
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
        details.put("title", this.title); // El enunciado no lo pide, pero lo considero necesario
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
