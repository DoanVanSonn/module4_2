package com.codegym.ss7_jpa.service;

import com.codegym.ss7_jpa.bean.Blog;
import com.codegym.ss7_jpa.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IService<Blog>{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public void save(Blog blog) {
blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void delete(int id) {
blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAllByCategory_Id(int id) {
        return blogRepository.findAllByCategory_Id(id);
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.findByName(name);
    }
}
