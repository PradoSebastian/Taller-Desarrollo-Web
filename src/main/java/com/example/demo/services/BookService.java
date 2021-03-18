package com.example.demo.services;

import com.example.demo.models.Book;

import java.util.HashMap;
import java.util.List;

public interface BookService {
    public long createBook(Book book) throws Exception;
    public HashMap<String, String> getDetailsByID(long idBook) throws Exception;
    public List<HashMap<String, String>> getBooksByAuthorNames(String authorNames) throws Exception;
}
