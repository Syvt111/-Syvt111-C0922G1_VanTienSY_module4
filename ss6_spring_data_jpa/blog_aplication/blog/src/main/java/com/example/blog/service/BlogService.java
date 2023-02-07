package com.example.blog.service;

import com.example.blog.model.BlogApp;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository blogRepository ;

    @Override
    public List<BlogApp> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public BlogApp findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(BlogApp blogApp) {
        blogRepository.save(blogApp) ;

    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);

    }

    @Override
    public List<BlogApp> findBlogAppByBlog_nameContaining(String name) {

        return blogRepository.findBlogAppByBlog_nameContaining(name);
    }
}
