package com.sda.phonebook.repository;

import com.sda.phonebook.model.PhoneContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

//@NamedQuery(name = "PhoneContactService.findByLastname", query = " SELECT ...")
@Repository
public interface PhoneContactRepository extends JpaRepository<PhoneContact, Integer> {

    //keywords: find, create, delete

    List<PhoneContact> findByFirstname(String firstname);
    List<PhoneContact> findByFirstnameAndLastname(String firsname, String lastname);

}
