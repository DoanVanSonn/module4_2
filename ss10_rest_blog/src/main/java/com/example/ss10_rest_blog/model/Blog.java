package com.example.ss10_rest_blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Please input name")
    private String name;
    @NotBlank(message = "Please input content")
    private String content;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_category",referencedColumnName = "idCategory")
    private CategoryBlog categoryBlog;
    public Blog() {
    }

    public Blog(Integer id, String name, String content, CategoryBlog categoryBlog) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.categoryBlog = categoryBlog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryBlog getCategoryBlog() {
        return categoryBlog;
    }

    public void setCategoryBlog(CategoryBlog categoryBlog) {
        this.categoryBlog = categoryBlog;
    }}
