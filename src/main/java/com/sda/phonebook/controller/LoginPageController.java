package com.sda.phonebook.controller;

import com.sda.phonebook.model.Login;
import com.sda.phonebook.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

public class LoginPageController {


    @Autowired
    private LoginService loginService;

    private Logger logger = Logger.getLogger(PhoneContactController.class.getName());

//    @GetMapping("/login")
//    public String someData() {
//        //TODO: Must be implemented
//        return "loginsuccess";
//    }

    @RequestMapping(value = "/createlogin", method= RequestMethod.POST)
    public String addLogin(Login login) {
        logger.info("Saving login: " + login);
        loginService.createLogin(login);
        logger.info("Login " + login + " successfully saved!");
        return "loginsuccess";
    }

    @GetMapping("/logins")
    public String displayAllLogins(Model model) {
        model.addAttribute("logins", loginService.getAllLogins());
        return "logins";
    }

    @DeleteMapping("/logins/{id}")
    public void deleteLogin(@PathVariable("id") Integer id) {
        loginService.deleteLogin(id);
    }

    @PutMapping("/logins/{id}")
    public void updateContact(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password) {
        loginService.updateLogin(id, username, password);
    }


}
