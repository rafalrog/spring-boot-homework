package com.sda.phonebook.service;

import com.sda.phonebook.model.Login;
import com.sda.phonebook.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Objects;

@Service
@EnableTransactionManagement
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;

    public void createLogin(Login login) {
        loginRepository.save(login);
    }

    public void updateLogin(int id, String username, String password) {
        //.. TODO:
        Login login = loginRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("login with id " + id + " does not exist"));

        if (username != null && username.length() > 0 && !Objects.equals(login.getUsername(), username)) {
            login.setUsername(username);
        }
        if (password != null && password.length() > 0 && !Objects.equals(login.getPassword(), password)) {
            login.setPassword(password);
        }
    }

    public void deleteLogin(int id) {
        //File I/O
        //loginRepository.deleteById(id);
        //@Transactional manages transactions recursively in the method/class it is set on top of.
        //invokes some other method, and in that method, you also have a block of operations, they are all under
        //same transaction!
        //.. TODO: implement delete
        boolean exists = loginRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("login with id " + id + " does not exist");
        }
        loginRepository.deleteById(id);
    }

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }



}
