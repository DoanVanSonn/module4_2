package com.example.validationn.service;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IUserService<E> {
    List<E> findAll();
    void save(E e);
    void deleteById(int id);
    void findById(int id);
}
