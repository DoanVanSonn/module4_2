package com.example.ss10_session_cookie.controller;

import com.example.ss10_session_cookie.model.Product;
import com.example.ss10_session_cookie.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class RestProductController {
    @Autowired
    IProductService productService;

    @PostMapping(value = "/update-product")
    public ResponseEntity<List<Product>> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}

