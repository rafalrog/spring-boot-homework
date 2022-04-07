package com.sda.phonebook.service;

import com.sda.phonebook.model.PhoneContact;
import com.sda.phonebook.repository.PhoneContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

@Service //Implements Business Layer
@EnableTransactionManagement
public class PhoneContactService {

    @Autowired
    private PhoneContactRepository phoneContactRepository;

    public void createPhoneContact(PhoneContact pc) {
        phoneContactRepository.save(pc);
    }

    public PhoneContact updatePhoneContact(int id) {
        //.. TODO:
        return null;
    }


    @Transactional(dontRollbackOn = )
    public void deletePhoneContact(int id) {
        //File I/O
        phoneContactRepository.deleteById(id);
        //@Transactional manages transactions recursively in the method/class it is set on top of.
        //invokes some other method, and in that method, you also have a block of operations, they are all under
        //same transacrtion!
        //.. TODO: implement delete
    }

    public List<PhoneContact> getAllContacts() {
        return phoneContactRepository.findAll();
    }



}
