package com.sda.phonebook.repository;

import com.sda.phonebook.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

//@NamedQuery(name = "PhoneContactService.findByLastname", query = " SELECT ...")
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    //keywords: find, create, delete

}
