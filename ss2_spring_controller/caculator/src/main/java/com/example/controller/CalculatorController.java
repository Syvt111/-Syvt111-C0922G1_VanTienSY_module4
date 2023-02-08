package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("")
    public String display() {
        return "/index";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam String calculator, double number1, double number2, Model model) {
        double result;
        String resultString = "";
        switch (calculator) {
            case "+":
                result = number1 + number2;
                resultString = String.valueOf(result);
                break;
            case "-":
                result = number1 - number2;
                resultString = String.valueOf(result);
                break;
            case "*":
                result = number1 * number2;
                resultString = String.valueOf(result);
                break;
            case "/":
                try {
                    result = number1 / number2;
                    resultString = String.valueOf(result);
                    break;
                }catch (ArithmeticException e){
                    String mes = "không thể chia cho 0";
                    System.out.println(mes);
                }
        }
        model.addAttribute("result",resultString);
        return "/index";
    }
}
