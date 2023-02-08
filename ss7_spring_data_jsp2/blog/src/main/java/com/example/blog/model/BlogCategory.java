package com.example.blog.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class BlogCategory  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "blogCategory",cascade = CascadeType.ALL)
    private Set<BlogApp> blogAppSet ;

    public BlogCategory() {
    }

    public BlogCategory(int id, String name, Set<BlogApp> blogAppSet) {
        this.id = id;
        this.name = name;
        this.blogAppSet = blogAppSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BlogApp> getBlogAppSet() {
        return blogAppSet;
    }

    public void setBlogAppSet(Set<BlogApp> blogAppSet) {
        this.blogAppSet = blogAppSet;
    }
}
