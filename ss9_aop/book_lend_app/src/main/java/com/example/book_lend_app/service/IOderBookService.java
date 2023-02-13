package com.example.book_lend_app.service;

import com.example.book_lend_app.model.OrderBook;
import com.example.book_lend_app.repository.IOrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOderBookService implements IOrderBookService {
    @Autowired
    private IOrderBookRepository iOrderBookRepository;

    @Override
    public List<OrderBook> findAll() {
        return iOrderBookRepository.findAll();
    }

    @Override
    public OrderBook findById(int id) {
        return iOrderBookRepository.findById(id).get();
    }

    @Override
    public void save(OrderBook orderBook) {
        iOrderBookRepository.save(orderBook);

    }

    @Override
    public void delete(int id) {
        iOrderBookRepository.deleteById(id);
    }

    @Override
    public OrderBook findOrderBookByCode(int code) {
        return iOrderBookRepository.findOrderBookByCode(code);
    }
}
