package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeasoningSandwichController {
    @GetMapping("")
    public String showList(){
        return "/index";
    }
    @PostMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
        String message = "";
        if (condiment.length == 0) {
            message = "Bạn chưa chọn";
            model.addAttribute("message", message);
        } else {
            model.addAttribute("condiment", condiment);
        }
        return "/index";
    }
}
