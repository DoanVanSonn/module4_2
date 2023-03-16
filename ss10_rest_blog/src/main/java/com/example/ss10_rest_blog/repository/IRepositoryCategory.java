package com.example.ss10_rest_blog.repository;

import com.example.ss10_rest_blog.model.Blog;
import com.example.ss10_rest_blog.model.CategoryBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCategory extends JpaRepository<CategoryBlog,Integer> {
}
