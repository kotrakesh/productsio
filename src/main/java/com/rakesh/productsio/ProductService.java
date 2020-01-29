package com.rakesh.productsio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAllProducts(){

        List<Product> Products = new ArrayList<>();
        productCrudRepository.findAll()
                .forEach(Products::add);
        return Products;
    }

    public void addProduct(Product product){
        productCrudRepository.save(product);
    }

    public Optional<Product> getProduct(int id){
        return productCrudRepository.findById(id);
    }
}
