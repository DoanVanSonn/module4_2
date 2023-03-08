package com.example.ss9aop.repository;

import com.example.ss9aop.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
