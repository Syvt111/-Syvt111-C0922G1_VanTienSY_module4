package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("")
    public String showList(){
        return "/home" ;
    }
}
