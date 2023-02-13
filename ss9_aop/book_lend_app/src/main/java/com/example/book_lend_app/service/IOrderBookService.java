package com.example.book_lend_app.service;

import com.example.book_lend_app.model.Book;
import com.example.book_lend_app.model.OrderBook;

import java.util.List;

public interface IOrderBookService {

    List<OrderBook> findAll();

    OrderBook findById(int id);

    void save(OrderBook orderBook);

    void delete(int id);

    OrderBook findOrderBookByCode(int code);
}
