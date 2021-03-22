package com.example.demo.services.formater;

public class XmlFormater implements Formater {

    public String Format(String message) {
        return "<element att='bookCard'>" + message + "</element>";
    }
}
