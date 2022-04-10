package com.sda.phonebook.service;

import com.sda.phonebook.model.PhoneContact;
import com.sda.phonebook.repository.PhoneContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Objects;

@Service
@EnableTransactionManagement
public class PhoneContactService {

    @Autowired
    private PhoneContactRepository phoneContactRepository;

    public void createPhoneContact(PhoneContact pc) {
        phoneContactRepository.save(pc);
    }

    public void updatePhoneContact(int id, String firstname, String lastname, String phonenumber, String email) {
        //.. TODO:
        PhoneContact phoneContact = phoneContactRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("contact with id " + id + " does not exist"));

        if (firstname != null && firstname.length() > 0 && !Objects.equals(phoneContact.getFirstname(), firstname)) {
            phoneContact.setFirstname(firstname);
        }
        if (lastname != null && lastname.length() > 0 && !Objects.equals(phoneContact.getLastname(), lastname)) {
            phoneContact.setLastname(lastname);
        }
        if (phonenumber != null && phonenumber.length() > 0 && !Objects.equals(phoneContact.getPhonenumber(), phonenumber)) {
            phoneContact.setPhonenumber(phonenumber);
        }
        if (email != null && email.length() > 0 && !Objects.equals(phoneContact.getEmail(), email)) {
            phoneContact.setEmail(email);
        }
    }

    public void deletePhoneContact(int id) {
        //File I/O
        //phoneContactRepository.deleteById(id);
        //@Transactional manages transactions recursively in the method/class it is set on top of.
        //invokes some other method, and in that method, you also have a block of operations, they are all under
        //same transaction!
        //.. TODO: implement delete
        boolean exists = phoneContactRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("contact with id " + id + " does not exist");
        }
        phoneContactRepository.deleteById(id);

    }

    public List<PhoneContact> getAllContacts() {
        return phoneContactRepository.findAll();
    }



}
