package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
@Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);

    }

    @Override
    public Product findByID(int id) {
        return productRepository.findByID(id);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);

    }

//    @Override
//    public List<Product> search(String name) {
//        return productRepository.search(name);
//    }
}
