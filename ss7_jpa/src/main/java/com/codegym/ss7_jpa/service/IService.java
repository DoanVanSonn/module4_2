package com.codegym.ss7_jpa.service;

import java.util.List;

public interface IService<E> {
    void save(E e);
    List<E> findAll();
    void delete(int id);
    E findById(int id);
    List<E> findAllByCategory_Id(int id);
    List<E> findByName(String name);
}
