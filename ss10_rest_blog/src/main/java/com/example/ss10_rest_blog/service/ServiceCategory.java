package com.example.ss10_rest_blog.service;

import com.example.ss10_rest_blog.model.CategoryBlog;
import com.example.ss10_rest_blog.repository.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceCategory implements IServiceCategory {


    @Override
    public void save(CategoryBlog c) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CategoryBlog> findAll() {
        return null;
    }

    @Override
    public CategoryBlog findById(Long id) {
        return null;
    }
}
