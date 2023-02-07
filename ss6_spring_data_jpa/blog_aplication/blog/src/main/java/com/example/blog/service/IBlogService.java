package com.example.blog.service;

import com.example.blog.model.BlogApp;

import javax.persistence.Entity;
import java.util.List;

public interface IBlogService {
List<BlogApp>findAll();
BlogApp findById(int id);
void save(BlogApp blogApp);
void delete(int id);
List<BlogApp> findBlogAppByBlog_nameContaining(String name);

}
