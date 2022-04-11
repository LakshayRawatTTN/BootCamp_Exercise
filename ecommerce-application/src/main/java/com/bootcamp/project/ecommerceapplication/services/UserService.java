package com.bootcamp.project.ecommerceapplication.services;

import com.bootcamp.project.ecommerceapplication.domain.Role;
import com.bootcamp.project.ecommerceapplication.domain.User;
import com.bootcamp.project.ecommerceapplication.exceptions.PasswordMismatch;
import com.bootcamp.project.ecommerceapplication.exceptions.UserNotFoundException;
import com.bootcamp.project.ecommerceapplication.models.LoginModel;
import com.bootcamp.project.ecommerceapplication.models.UserModel;
import com.bootcamp.project.ecommerceapplication.repositories.RoleRepository;
import com.bootcamp.project.ecommerceapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public User save(UserModel userModel) throws PasswordMismatch {
        if(!userModel.getPassword().equals(userModel.getConfirmPassword())){
            throw new PasswordMismatch("password and confirm password are not same");
        }
        User user = new User(userModel);
        User currentUser = User.currentUser();
        System.out.println(currentUser);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        List<Role> roles = roleRepository.findAllByIdIn(userModel.getRoles());
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }

    public Map<String, Object> getUser(String email) throws UserNotFoundException {
        HashMap<String, Object> response = new HashMap<>();
        User user = userRepository.findByEmail(email);
        if(user!=null){
        response.put("user", user);
        return response;
        }
        throw new UserNotFoundException("user is not registered");
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        List<GrantedAuthority> authorities
                = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        return authorities;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User Not Found for Email" + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user.getRoles()));

    }

    public User passwordUpdate(){
        return User.currentUser();
    }



}
