package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);

    void edit(Product product);

    Product findByID(int id);

    void remove(int id);

    List<Product> search(String name);
}
