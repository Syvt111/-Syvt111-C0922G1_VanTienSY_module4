package com.example.blog.controller;

import com.example.blog.model.BlogApp;
import com.example.blog.model.BlogCategory;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    private ICategoryService categoryService;

    public BlogRestController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<BlogApp>> getAllBlog() {
        List<BlogApp> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<BlogCategory>> getAllBlogCategory() {
        List<BlogCategory> blogCategoryList = categoryService.findAll();
        if (blogCategoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogCategoryList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogApp> view(@PathVariable int id, Model model) {
        BlogApp blogApp = blogService.findById(id);

        if (blogApp == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogApp,HttpStatus.OK);
    }
}
