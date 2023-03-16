package com.example.ss10_rest_blog.service;

import com.example.ss10_rest_blog.model.CategoryBlog;

import java.util.List;

public interface IServiceCategory {

    void save(CategoryBlog c);
    void delete(Long id);
    List<CategoryBlog> findAll();
    CategoryBlog findById(Long id);

}
