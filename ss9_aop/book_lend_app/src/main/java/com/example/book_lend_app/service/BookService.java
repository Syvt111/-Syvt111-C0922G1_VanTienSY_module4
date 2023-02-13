package com.example.book_lend_app.service;

import com.example.book_lend_app.model.Book;
import com.example.book_lend_app.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Book findBookByNameContaining(String name) {
        return bookRepository.findBookByNameContaining(name);
    }

    @Override
    public Page<Book> findBookByNameContaining(String name, Pageable pageable) {
        return bookRepository.findBookByNameContaining(name, pageable);
    }
}
