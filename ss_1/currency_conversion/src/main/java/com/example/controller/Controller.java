package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("")
    public String showDisplay(){
        return "/index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam int value, Model model){
        model.addAttribute("result","Result"  + value + " USD = " + value*23000 + " VND") ;
        return "/index";
    }

}
