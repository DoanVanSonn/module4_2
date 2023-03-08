package com.example.ss9aop.service;

import java.util.List;

public interface IService <E>{
    List<E> findAll();
    E findById(int id);
    void save(E e);
    void delete(E e);

}
