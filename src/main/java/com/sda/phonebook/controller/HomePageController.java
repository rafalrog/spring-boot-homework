package com.sda.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/index")
    public String someData() {
        //TODO: Must be implemented
        return "index";
    }

}
