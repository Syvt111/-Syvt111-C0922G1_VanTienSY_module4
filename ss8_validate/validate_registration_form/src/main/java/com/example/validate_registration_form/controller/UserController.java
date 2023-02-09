package com.example.validate_registration_form.controller;

import com.example.validate_registration_form.model.User;
import com.example.validate_registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String ShowList(Model model) {
        model.addAttribute("userList", userService.findAll());

        return "/home";
    }

    @GetMapping("/register")
    public String showForm(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/register")
    public String save(@Validated @ModelAttribute User user,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            model.addAttribute("user",user);
            return "register";
        }
        redirectAttributes.addFlashAttribute("mes","Successfully !");
        userService.save(user);

        return "redirect:/";
    }
}
