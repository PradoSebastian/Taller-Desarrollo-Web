package com.example.demo.services.formater;

public class HtmlFormater implements Formater{

    public String Format(String message) {
        return "<p>" + message + "</p>";
    }
}
