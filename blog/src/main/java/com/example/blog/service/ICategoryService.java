package com.example.blog.service;

import com.example.blog.model.BlogApp;
import com.example.blog.model.BlogCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Locale;

public interface ICategoryService {
    List<BlogCategory> findAll();

    BlogCategory findById(int id);

    void save(BlogCategory category);

    void delete(int id);

    Page<BlogCategory> findBlogAppByNameContaining(String name, Pageable pageable);

    Page<BlogCategory> searchByNameContaining(String name, Pageable pageable);

    Page<BlogCategory> findAll(Pageable pageable);
}
