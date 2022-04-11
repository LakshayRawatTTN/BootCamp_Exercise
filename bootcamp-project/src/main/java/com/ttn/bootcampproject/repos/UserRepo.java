package com.ttn.bootcampproject.repos;

import com.ttn.bootcampproject.controllers.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);

}
