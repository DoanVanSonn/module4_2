package com.example.ss10_session_cookie.repository;

import com.example.ss10_session_cookie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {

}
