package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.demo.BooksApplication.LOGGER;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public long createBook(Book book) throws Exception {

        if(!book.validateTitle())
            throw new Exception("BookServiceImpl.createBook Causa: " +
                    "The title must be between 5 and 100 characters");

        if(!book.validateDescription())
            throw new Exception("BookServiceImpl.createBook Causa: " +
                    "The description must be less than 200 characters");

        if(!book.validatePrice())
            throw new Exception("BookServiceImpl.createBook Causa: " +
                    "The price should not be less than 10000 pesos and should be positive");

        if(!book.validateAuthorNames())
            throw new Exception("BookServiceImpl.createBook Causa: " +
                    "The authorNames must include author's name and last name, also it must be less than 100 characters");

        if(!book.validatePublishedYear())
            throw new Exception("BookServiceImpl.createBook Causa: " +
                    "The publishedYear must be a valid year, also it must be exactly 4 characters");

        if(!book.validateNumberPages())
            throw new Exception("BookServiceImpl.createBook Causa: " +
                    "The numberPages must be a positive number, also it must be less than 1500");

        try {
            book = this.bookRepository.save(book);
        }
        catch (Exception e) {
            LOGGER.error("BookServiceImpl.createBook Causa: " + e.toString());
            throw new Exception("BookServiceImpl.createBook Causa: " + e.toString());
        }
        return book.getId();
    }

    @Override
    public HashMap<String, String> getDetailsByID(long idBook) throws Exception {
        Book book = null;
        try {
            book = this.bookRepository.findById(idBook).get();
        }
        catch (Exception e) {
            LOGGER.error("BookServiceImpl.getDetailsByID Causa: " + e.toString());
            throw new Exception("BookServiceImpl.getDetailsByID Causa: " + e.toString());
        }
        return book.getDetails();
    }

    @Override
    public List<HashMap<String, String>> getBooksByAuthorNames(String authorNames) throws Exception {

        List<HashMap<String, String>> result = new ArrayList<>();
        try {
            List<Book> books = this.bookRepository.getBooksByAuthorNames(authorNames);
            for (Book b: books) {
                result.add(b.getAuthorDetails());
            }
        }
        catch (Exception e) {
            LOGGER.error("BookServiceImpl.getBooksByAuthorNames Causa: " + e.toString());
            throw new Exception("BookServiceImpl.getBooksByAuthorNames Causa: " + e.toString());
        }
        return result;
    }
}
