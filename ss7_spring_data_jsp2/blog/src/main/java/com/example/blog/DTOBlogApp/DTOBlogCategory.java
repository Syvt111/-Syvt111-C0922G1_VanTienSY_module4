package com.example.blog.DTOBlogApp;


import javax.persistence.*;
import java.util.Set;

@Entity
public class DTOBlogCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "blogCategory",cascade = CascadeType.ALL)
    private Set<DTOBlogApp> blogAppSet ;

    public DTOBlogCategory() {
    }

    public DTOBlogCategory(int id, String name, Set<DTOBlogApp> blogAppSet) {
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

    public Set<DTOBlogApp> getBlogAppSet() {
        return blogAppSet;
    }

    public void setBlogAppSet(Set<DTOBlogApp> blogAppSet) {
        this.blogAppSet = blogAppSet;
    }
}
