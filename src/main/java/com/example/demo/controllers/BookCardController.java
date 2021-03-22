package com.example.demo.controllers;

import com.example.demo.useCases.BookCardFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCardController {

    private BookCardFinder bookCardFinder;

    @Autowired
    public BookCardController(BookCardFinder bookCardFinder) {
        this.bookCardFinder = bookCardFinder;
    }

    @RequestMapping("/healthCheck")
    public String HealtCheck() {
        return "OK";
    }

    @RequestMapping("/bookCardFinder")
    public String execute() {
        return bookCardFinder.execute();
    }
}
