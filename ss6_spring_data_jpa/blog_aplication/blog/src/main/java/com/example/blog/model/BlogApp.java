package com.example.blog.model;

import javax.persistence.*;


@Entity
public class BlogApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String blog_name;
    private String summary;

    @Column(columnDefinition = "longText")
    private String content;

    public BlogApp() {
    }

    public BlogApp(int id, String blog_name, String summary, String content) {
        this.id = id;
        this.blog_name = blog_name;
        this.summary = summary;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlog_name() {
        return blog_name;
    }

    public void setBlog_name(String blog_name) {
        this.blog_name = blog_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
