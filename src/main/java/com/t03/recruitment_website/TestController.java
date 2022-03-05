package com.t03.recruitment_website;


import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping
    public String showHomePage(){
        return "index";
    }
}
