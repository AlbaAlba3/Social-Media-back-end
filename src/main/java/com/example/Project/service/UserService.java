package com.example.Project.service;

import com.example.Project.model.Provider;
import com.example.Project.model.User;
import com.example.Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void processOAuthPostLogin(String username) {
        User existUser = repo.findByUsername(username).isPresent() ?
                repo.findByUsername(username).get(): null;

        System.out.println(existUser);
        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);

            repo.save(newUser);
        }

    }

}