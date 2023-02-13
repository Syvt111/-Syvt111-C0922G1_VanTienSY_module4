package com.example.book_lend_app.service;

import com.example.book_lend_app.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void delete(int id);
    Book findBookByNameContaining(String name);
    Page<Book> findBookByNameContaining(String name, Pageable pageable);
}
