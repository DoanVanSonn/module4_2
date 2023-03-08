package com.example.ss10_session_cookie.service;

import com.example.ss10_session_cookie.model.Product;
import com.example.ss10_session_cookie.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProduct(Product product) {
productRepository.save(product);
    }
}
