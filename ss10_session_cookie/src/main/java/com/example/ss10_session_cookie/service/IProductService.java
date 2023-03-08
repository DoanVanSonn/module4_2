package com.example.ss10_session_cookie.service;

import com.example.ss10_session_cookie.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    void updateProduct(Product product);
}
