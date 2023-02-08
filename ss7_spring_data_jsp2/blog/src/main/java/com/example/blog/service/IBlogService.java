package com.example.blog.service;

import com.example.blog.model.BlogApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<BlogApp> findAll();

    BlogApp findById(int id);

    void save(BlogApp blogApp);

    void delete(int id);

    Page<BlogApp> findBlogAppByNameContaining(String name, Pageable pageable);

    Page<BlogApp> searchByNameContaining(String name, Pageable pageable);

    Page<BlogApp> findAll(Pageable pageable);

}
