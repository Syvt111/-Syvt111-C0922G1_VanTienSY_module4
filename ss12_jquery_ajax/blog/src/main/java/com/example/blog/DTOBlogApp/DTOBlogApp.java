package com.example.blog.DTOBlogApp;

import javax.persistence.*;


@Entity
public class DTOBlogApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String summary;
    private String dateCreate;

    @Column(columnDefinition = "longText")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private DTOBlogCategory blogCategory ;

    public DTOBlogApp() {
    }

    public DTOBlogApp(int id, String name, String summary, String content, String dateCreate) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.content = content;
        this.dateCreate = dateCreate;
    }
    public DTOBlogApp(int id, String name, String summary, String content, String dateCreate, DTOBlogCategory blogCategory) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.content = content;
        this.dateCreate = dateCreate;
        this.blogCategory = blogCategory;
    }

    public DTOBlogCategory getBlogCategory() {
        return blogCategory;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setBlogCategory(DTOBlogCategory blogCategory) {
        this.blogCategory = blogCategory;
    }
}
