package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public String ShowList(Model model) {
        List<Product> productList;
        productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/home";
    }

    @GetMapping("/create")
    public String ShowCreate(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/edit/{id}")
    public String ShowEdit(@PathVariable int id, Model model) {
        Product product = productService.findByID(id);
        if (product == null) {
            model.addAttribute("msg", "Không Tìm Thấy !");
            return "redirect:/";
        } else {
            model.addAttribute("product", product);
            model.addAttribute("id",id);
            return "/edit";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable int id, RedirectAttributes attributes) {
        productService.remove(id);
        attributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> productList =  productService.search(name) ;
        model.addAttribute("productList", productList);
        return "/home";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Product product, RedirectAttributes attributes) {
        productService.save(product);
        attributes.addFlashAttribute("msg", "Thành công !");
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes attributes) {
        productService.edit(product);
        attributes.addFlashAttribute("msg", "Thành Công !");
        return "redirect:/";
    }

}
