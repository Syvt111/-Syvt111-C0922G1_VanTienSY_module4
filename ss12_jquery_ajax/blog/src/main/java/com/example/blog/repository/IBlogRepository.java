package com.example.blog.repository;

import com.example.blog.model.BlogApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<BlogApp, Integer> {

    Page<BlogApp> findBlogAppByNameContaining(String name,Pageable pageable);

    Page<BlogApp> searchByNameContaining(String name, Pageable pageable);

    List<BlogApp> findByContentContaining(String content);

//    @Query(value = "select * from blog_app where name like :name", nativeQuery = true)
//    List<BlogApp> findBlogAppByNameContaining(@Param("name") String name);


}

