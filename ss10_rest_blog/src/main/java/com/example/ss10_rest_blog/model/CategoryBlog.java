package com.example.ss10_rest_blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class CategoryBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String nameCategory;
    @OneToMany(mappedBy = "categoryBlog")
    @JsonBackReference
    private Set<Blog> blogs;

    public CategoryBlog() {
    }

    public CategoryBlog(Integer idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public CategoryBlog(Integer idCategory, String nameCategory, Set<Blog> blogs) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.blogs = blogs;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
