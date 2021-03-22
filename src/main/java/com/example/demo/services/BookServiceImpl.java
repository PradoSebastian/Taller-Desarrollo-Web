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
            throw new Exception("BookServiceImpl.createBook Cause: " +
                    "The title must be between 5 and 100 characters");

        if(!book.validateDescription())
            throw new Exception("BookServiceImpl.createBook Cause: " +
                    "The description must be less than 200 characters");

        if(!book.validatePrice())
            throw new Exception("BookServiceImpl.createBook Cause: " +
                    "The price should not be less than 10000 pesos and should be positive");

        if(!book.validateAuthorNames())
            throw new Exception("BookServiceImpl.createBook Cause: " +
                    "The authorNames must include author's name and last name, also it must be less than 100 characters");

        if(!book.validatePublishedYear())
            throw new Exception("BookServiceImpl.createBook Cause: " +
                    "The publishedYear must be a valid year, also it must be exactly 4 characters");

        if(!book.validateNumberPages())
            throw new Exception("BookServiceImpl.createBook Cause: " +
                    "The numberPages must be a positive number, also it must be less than 1500");

        try {
            if(validateBookExist(book.getId()))
                throw new Exception("Book already exists");

            book = this.bookRepository.save(book);
        }
        catch (Exception e) {
            LOGGER.error("BookServiceImpl.createBook Cause: " + e.toString());
            throw new Exception("BookServiceImpl.createBook Cause: " + e.toString());
        }
        return book.getId();
    }

    private boolean validateBookExist(long id) {
        boolean result = true;
        try {
            Book aux = this.bookRepository.findById(id).get();
            if(aux == null)
                result = false;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public HashMap<String, String> getDetailsByID(long idBook) throws Exception {
        Book book = null;
        try {
            book = this.bookRepository.findById(idBook).get();
        }
        catch (Exception e) {
            LOGGER.error("BookServiceImpl.getDetailsByID Cause: " + e.toString());
            throw new Exception("BookServiceImpl.getDetailsByID Cause: " + e.toString());
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
            LOGGER.error("BookServiceImpl.getBooksByAuthorNames Cause: " + e.toString());
            throw new Exception("BookServiceImpl.getBooksByAuthorNames Cause: " + e.toString());
        }
        return result;
    }
}
