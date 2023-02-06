package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @GetMapping("")
    public String Display(){
        return "/index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String word, Model model){
        String result = "";
        switch (word){
            case "red":
                result = "Đỏ";
                break;
            case "yellow":
                result = "vàng";
                break;
            case "white":
                result = "trắng";
                break;
                case "black":
                result = "đen";
                break;
                case "blue":
                result = "xanh";
                break;
            default:
                result = "Not Found";
        }
        model.addAttribute("result", result);

        return "/index";
    }
}
