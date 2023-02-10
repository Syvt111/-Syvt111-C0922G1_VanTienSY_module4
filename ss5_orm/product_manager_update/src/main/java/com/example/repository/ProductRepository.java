package com.example.repository;

import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
@PersistenceContext
@Autowired
   private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList ;
        productList=entityManager.createQuery("select p from Product as p").getResultList();
        return productList;
    }

    @Override
    @Transactional
    public void save(Product product) {

        entityManager.persist(product);
    }

    @Override
    @Transactional
    public void edit(Product product) {
        Product product1 =findByID(product.getId());
        product1.setPrice(product.getPrice());
        product1.setName(product.getName());
        entityManager.merge(product1);
    }

    @Override
    public Product findByID(int id) {
        return  entityManager.find(Product.class,id);
    }

    @Override
    @Transactional
    public void remove(Product product ) {
        Product product1 =findByID(product.getId());
       entityManager.remove(product1);

    }

//    @Override
//    public List<Product> search(String name) {
//        List<Product> products = new ArrayList<>();
//        for (Product product : productList) {
//            if (product.getName().contains(name)) {
//                products.add(product);
//            }
//        }
//        return products ;
//    }

}
