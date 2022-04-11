package com.bootcamp.project.ecommerceapplication.services;

import com.bootcamp.project.ecommerceapplication.domain.User;
import com.bootcamp.project.ecommerceapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public boolean activate(String email) {
        User userFound = userRepository.findByEmail(email);
        if (userFound.getEmail().equals(email)) {
            if (!userFound.isIs_active()) {
                userFound.setIs_active(true);
                userRepository.updateUser(email);
            }
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deactivate(String user) {
        User userFound = userRepository.findByEmail(user);
        if (userFound.getEmail().equals(user)) {
            if (userFound.isIs_active()) {
                userFound.setIs_active(false);
                userRepository.updateUser(user);
            }
            return true;
        }
        return false;
    }

}
