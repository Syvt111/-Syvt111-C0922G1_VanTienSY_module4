package com.example.blog.controller;

import com.example.blog.model.BlogApp;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String ShowAll(Model model) {
        List<BlogApp> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);

        return "/home";
    }

    @GetMapping("/create")
    public String ShowFormCreate(@ModelAttribute BlogApp blogApp, Model model) {
        model.addAttribute("blog", new BlogApp());
        return "/create";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model) {
        BlogApp blogApp = blogService.findById(id);
        model.addAttribute("blog", blogApp);

        return "/view";
    }

    @GetMapping("/search")
    public String showView(@RequestParam String name, Model model) {
        List<BlogApp> blogList = blogService.findBlogAppByBlog_nameContaining(name);
        model.addAttribute("blogList",blogList);
        return "/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        blogService.delete(id);
        attributes.addFlashAttribute("msg", "Successfully !");
        return "redirect:/";
    }

    @PostMapping("/create")
    public String Create(@ModelAttribute BlogApp blogApp, RedirectAttributes attributes) {
        blogService.save(blogApp);
        attributes.addFlashAttribute("msg", "Successfully !");
        return "redirect:/";
    }
}
