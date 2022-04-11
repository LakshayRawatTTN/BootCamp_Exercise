package com.bootcamp.project.ecommerceapplication.controllers;

import com.bootcamp.project.ecommerceapplication.domain.Address;
import com.bootcamp.project.ecommerceapplication.domain.Seller;
import com.bootcamp.project.ecommerceapplication.domain.User;
import com.bootcamp.project.ecommerceapplication.exceptions.UserNotFoundException;
import com.bootcamp.project.ecommerceapplication.models.AddressModel;
import com.bootcamp.project.ecommerceapplication.models.SellerModel;
import com.bootcamp.project.ecommerceapplication.models.UserModel;
import com.bootcamp.project.ecommerceapplication.repositories.UserRepository;
import com.bootcamp.project.ecommerceapplication.services.SellerService;
import com.bootcamp.project.ecommerceapplication.services.UserService;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class SellerController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Seller register(@RequestBody SellerModel seller) {
        return sellerService.addSeller(seller);
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<Map>  viewProfile(@PathVariable String email) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
    }


    //new api
    @PostMapping("/address")
    public ResponseEntity<User> addAddress(@RequestBody AddressModel addressModel) {
        return ResponseEntity.accepted().body(sellerService.addAddress(addressModel));

    }


    @GetMapping("/address/view")
    public ResponseEntity<Address> viewAddress() {
        return sellerService.findAddress();
    }

}
