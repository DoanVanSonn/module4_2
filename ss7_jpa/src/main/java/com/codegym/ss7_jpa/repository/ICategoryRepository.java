package com.codegym.ss7_jpa.repository;

import com.codegym.ss7_jpa.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
