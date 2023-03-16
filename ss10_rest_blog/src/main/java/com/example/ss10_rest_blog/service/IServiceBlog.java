package com.example.ss10_rest_blog.service;

import com.example.ss10_rest_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceBlog {
    List<Blog> findAll();

    Blog findById(Integer id);

    void create(Blog blog);

    void update(Blog blog);

    void deleteById(Integer id);

    List<Blog> findAllByCategoryName(String name);

    Page<Blog> findAllWithPaging(Pageable pageable);

    Page<Blog> findAllWithPagingAndSort(Pageable pageable);

    Page<Blog> findAllByTittle(String title, Pageable pageable);
}
