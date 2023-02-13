package com.example.book_lend_app.repository;

import com.example.book_lend_app.model.Book;
import com.example.book_lend_app.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderBookRepository extends JpaRepository<OrderBook,Integer> {

    OrderBook findOrderBookByCode(int code);


}
