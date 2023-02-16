package com.example.blog.service;

import com.example.blog.model.BlogCategory;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<BlogCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public BlogCategory findById(int id) {
        return null;
    }

    @Override
    public void save(BlogCategory category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Page<BlogCategory> findBlogAppByNameContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<BlogCategory> searchByNameContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<BlogCategory> findAll(Pageable pageable) {
        return null;
    }
}
