package com.example.ss10_rest_blog.service;

import com.example.ss10_rest_blog.model.Blog;
import com.example.ss10_rest_blog.repository.IRepositoryBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceBlog implements IServiceBlog{
    @Autowired
    private IRepositoryBlog repositoryBlog;

    @Override
    public List<Blog> findAll() {
        return repositoryBlog.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return repositoryBlog.findById(id).orElse(null);
    }

    @Override
    public void create(Blog blog) {
repositoryBlog.save(blog);
    }

    @Override
    public void update(Blog blog) {
repositoryBlog.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
repositoryBlog.deleteById(id);
    }

    @Override
    public List<Blog> findAllByCategoryName(String name) {
        return repositoryBlog.findAllByCategoryName(name);
    }

    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return repositoryBlog.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllWithPagingAndSort(Pageable pageable) {
        return repositoryBlog.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTittle(String title, Pageable pageable) {
        return repositoryBlog.findAllByTitle(title,pageable);
    }

}
