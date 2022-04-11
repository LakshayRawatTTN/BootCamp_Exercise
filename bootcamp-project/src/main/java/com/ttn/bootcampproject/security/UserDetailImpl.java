package com.ttn.bootcampproject.security;

import com.ttn.bootcampproject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDetailImpl implements UserDetailsService{
    @Autowired
    UserRepo userRepo;


}
