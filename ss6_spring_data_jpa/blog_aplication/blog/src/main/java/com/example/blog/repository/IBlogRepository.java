package com.example.blog.repository;

import com.example.blog.model.BlogApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogApp, Integer> {

    @Query(value = "select * from blog_app where blog_name like :name", nativeQuery = true)
    List<BlogApp> findBlogAppByBlog_nameContaining(@Param("name") String name);

}

