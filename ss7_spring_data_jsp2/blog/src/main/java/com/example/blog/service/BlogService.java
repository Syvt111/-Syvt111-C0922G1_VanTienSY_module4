package com.example.blog.service;

import com.example.blog.model.BlogApp;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

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
        blogRepository.save(blogApp);

    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);

    }

    @Override
    public Page<BlogApp> findBlogAppByNameContaining(String name, Pageable pageable) {

        return blogRepository.findBlogAppByNameContaining(name, pageable);
    }

    @Override
    public Page<BlogApp> searchByNameContaining(String name, Pageable pageable) {
        return blogRepository.searchByNameContaining(name, pageable);
    }

    @Override
    public Page<BlogApp> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
