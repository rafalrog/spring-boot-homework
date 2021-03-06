package com.sda.phonebook.controller;

import com.sda.phonebook.model.PhoneContact;
import com.sda.phonebook.service.PhoneContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable("id") Integer id) {
        phoneContactService.deletePhoneContact(id);
    }

    @PutMapping("/contacts/{id}")
    public void updateContact(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String phonenumber,
            @RequestParam(required = false) String email) {
        phoneContactService.updatePhoneContact(id, firstname, lastname, phonenumber, email);
    }



}
