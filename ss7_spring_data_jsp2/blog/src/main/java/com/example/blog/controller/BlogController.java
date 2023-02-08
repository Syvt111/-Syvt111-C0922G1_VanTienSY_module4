package com.example.blog.controller;

import com.example.blog.model.BlogApp;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
   private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create")
    public String ShowCreate(@ModelAttribute BlogApp blogApp, Model model) {
        model.addAttribute("blog", new BlogApp());
        model.addAttribute("categoryList",categoryService.findAll());
        return "/create";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model) {
        BlogApp blogApp = blogService.findById(id);
        model.addAttribute("blog", blogApp);

        return "/view";
    }

    @GetMapping("")
    public String showAllAndSearchSort(@RequestParam(required = false,defaultValue = "") String name, Model model,
                             @PageableDefault(size = 2,page = 0,sort="name",direction = Sort.Direction.ASC)Pageable pageable) {
        Page<BlogApp> blogPage = blogService.findBlogAppByNameContaining(name,pageable);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("name",name);
        model.addAttribute("categoryList",categoryService.findAll());
        return "/home-page";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        blogService.delete(id);
        attributes.addFlashAttribute("msg", "Successfully !");
        return "redirect:/";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute BlogApp blogApp, RedirectAttributes attributes) {
        blogService.save(blogApp);
        attributes.addFlashAttribute("msg", "Successfully !");
        return "redirect:/";
    }
}
