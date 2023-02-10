package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);

    void edit(Product product);

    Product findByID(int id);

    void remove(Product product);

//    List<Product> search(String name);
}
