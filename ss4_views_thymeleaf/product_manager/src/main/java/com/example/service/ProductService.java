package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "car", 12000));
        productList.add(new Product(2, "mot0", 12000));
        productList.add(new Product(3, "bycle", 12000));
    }

    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(Product product) {
        for (Product product1 : productList
        ) {
            if (product1.getId() == product.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                break;
            }
        }
    }

    @Override
    public Product findByID(int id) {
        for (Product product : productList) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Product product1 = null;
        for (Product product : productList) {
            if (id == product.getId()) {
                product1 = product;
                break;
            }
        }
        productList.remove(product1);

    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products ;
    }
}
