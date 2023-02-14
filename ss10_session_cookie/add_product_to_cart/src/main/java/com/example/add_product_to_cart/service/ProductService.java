package com.example.add_product_to_cart.service;

import com.example.add_product_to_cart.model.Product;
import com.example.add_product_to_cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

        iProductRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }
}
