package com.example.blog.repository;

import com.example.blog.model.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface ICategoryRepository extends JpaRepository<BlogCategory,Integer> {
}
