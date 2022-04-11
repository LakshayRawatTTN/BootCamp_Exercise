package com.bootcamp.project.ecommerceapplication.services;

import com.bootcamp.project.ecommerceapplication.domain.*;
import com.bootcamp.project.ecommerceapplication.models.AddressModel;
import com.bootcamp.project.ecommerceapplication.models.SellerModel;
import com.bootcamp.project.ecommerceapplication.models.UserModel;
import com.bootcamp.project.ecommerceapplication.repositories.AddressRepository;
import com.bootcamp.project.ecommerceapplication.repositories.RoleRepository;
import com.bootcamp.project.ecommerceapplication.repositories.SellerRepository;
import com.bootcamp.project.ecommerceapplication.repositories.UserRepository;
import com.bootcamp.project.ecommerceapplication.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Seller addSeller(SellerModel sellerModel) {

        Seller seller = new Seller(sellerModel);
        User user = new User();
        user.setEmail(sellerModel.getEmail());
        user.setFirstName(sellerModel.getFirstName());
        user.setMiddleName(sellerModel.getMiddleName());
        user.setLastName(sellerModel.getLastName());
        user.setPassword(passwordEncoder.encode(sellerModel.getPassword()));
        List<Role> roles = roleRepository.findAllByIdIn(Arrays.asList(1L));
        user.setRoles(roles);
        seller.setUser(user);
        sellerRepository.save(seller);

        return seller;

    }

    public List<Seller> getList() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers;
    }

    public User viewProfile(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User addAddress(AddressModel addressModel) {
        User user =  User.currentUser();
        Address address = new Address(addressModel);
        addressRepository.save(address);
        user.setAddress(address);
        userRepository.save(user);
        return user;
    }

    public ResponseEntity<Address> findAddress(){
        User currentUser =  User.currentUser();
        User user = userRepository.findByEmail(currentUser.getEmail());
        Address address = user.getAddress();

        return new ResponseEntity<Address>(address,HttpStatus.FOUND);
    }
}
