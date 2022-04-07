package com.sda.phonebook.controller;

import com.sda.phonebook.model.PhoneContact;
import com.sda.phonebook.service.PhoneContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class PhoneContactController {

    @Autowired
    private PhoneContactService phoneContactService;

    private Logger logger = Logger.getLogger(PhoneContactController.class.getName());


    @RequestMapping(value = "/createcontact", method= RequestMethod.POST)
    public String addContact(PhoneContact pc) {
        logger.info("Saving contact: " + pc);
        phoneContactService.createPhoneContact(pc);
        logger.info("Contact " + pc + " successfully saved!");
        return "success";
    }

    @GetMapping("/contacts")
    public String displayAllContacts(Model model) {
        model.addAttribute("contacts", phoneContactService.getAllContacts());
        return "contacts";
    }

}
