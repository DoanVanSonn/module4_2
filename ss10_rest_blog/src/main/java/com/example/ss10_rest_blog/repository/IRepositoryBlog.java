package com.example.ss10_rest_blog.repository;

import com.example.ss10_rest_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {
    @Query(value = "select b from Blog as b where b.categoryName.categoryName = :name", nativeQuery = false)
    List<Blog> findAllByCategoryName(@Param("name") String categoryName);

    @Query(value = "select b from Blog as b where b.title like %:title%", nativeQuery = false)
    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
