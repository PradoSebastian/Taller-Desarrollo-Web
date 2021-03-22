package com.example.demo.useCases;

import com.example.demo.services.formater.Formater;
import com.example.demo.models.Book;
import com.example.demo.services.formater.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCardFinder {

    private Book book;
    private Formater formater;
    private Sender sender;

    @Autowired
    public BookCardFinder(Formater formater, Sender sender) {
        this.formater = formater;
        this.sender = sender;
        //book = new Book("La bruma infinita", "David", 2010, 42000d);
    }

    public String execute() {
        String formatedText = formater.Format(book.CreateBookCard());
        if(sender.sender(formatedText)) {
            return formatedText;
        }
        return "ERROR";
    }
}
