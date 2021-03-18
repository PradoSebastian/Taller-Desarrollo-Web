package com.example.demo.models;

public class Author {

    private String name;

    private String lastName;

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author() {

    }

    public String buildCompleteName() {
        return this.name + " " + this.lastName;
    }

}
