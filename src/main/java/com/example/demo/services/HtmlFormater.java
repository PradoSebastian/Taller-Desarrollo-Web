package com.example.demo.services;

import org.springframework.stereotype.Service;

public class HtmlFormater implements Formater{

    public String Format(String message) {
        return "<p>" + message + "</p>";
    }
}
