package com.holovin.holovin_lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("")
    public String getCalculatorPage(@RequestParam(value = "num1", required=false) String num1,
                                    @RequestParam(value = "num2", required=false) String num2,
                                    @RequestParam(value = "operation", required=false) String operation,
                                    Model model) {

        String response = null;
        int number1, number2;
        if (num1 == null || num2 == null) {
            response = "Repeat your request";
        } else {
            number1 = Integer.parseInt(num1);
            number2 = Integer.parseInt(num2);
            switch (operation) {
                case "+":
                    response = number1 + " + " + number2 + " = " +
                            (number1 + number2);
                    break;
                case "-":
                    response = number1 + " - " + number2 + " = " +
                            (number1 - number2);
                    break;
                case "/":
                    response = number1 + " / " + number2 + " = " +
                            (number1 / number2);
                    break;
                case "*":
                    response = number1 + " * " + number2 + " = " +
                            (number1 * number2);
                    break;
                default:
                    response = "Repeat your request";
                    break;
            }
        }

        model.addAttribute("message", response);
        return "calculator/calculator";
    }
}
