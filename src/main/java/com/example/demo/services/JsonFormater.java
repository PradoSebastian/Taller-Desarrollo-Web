package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class JsonFormater implements Formater {

    public String Format(String message) {
        return "{ 'bookCard' : '" + message + "' }";
    }
}
