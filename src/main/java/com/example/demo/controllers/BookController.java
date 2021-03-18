package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.example.demo.BooksApplication.LOGGER;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createBook(@RequestBody Book book) {
        HttpStatus code = HttpStatus.NOT_FOUND;
        long idBook = 0;
        try {
            idBook = this.bookService.createBook(book);
            code = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("BookController.createBook Cause: " + e.getMessage());
        }
        return ResponseEntity.status(code).body(idBook);
    }

    @GetMapping(value = "/details/{idBook}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, String>> getDetailsByID(@PathVariable long idBook) {
        HttpStatus code = HttpStatus.NOT_FOUND;
        HashMap<String, String> book = null;
        try {
            book = this.bookService.getDetailsByID(idBook);
            code = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("BookController.getDetailsByID Cause: " + e.getMessage());
        }
        return ResponseEntity.status(code).body(book);
    }

    @GetMapping(value = "/author/{authorNames}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap<String, String>>> getBooksByAuthorNames(@PathVariable String authorNames) {
        HttpStatus code = HttpStatus.NOT_FOUND;
        List<HashMap<String, String>> books = null;
        try {
            books = this.bookService.getBooksByAuthorNames(authorNames);
            code = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("BookController.getBooksByAuthorNames Cause: " + e.getMessage());
        }
        return ResponseEntity.status(code).body(books);
    }
}
