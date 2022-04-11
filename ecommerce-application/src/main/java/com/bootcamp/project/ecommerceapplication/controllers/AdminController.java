package com.bootcamp.project.ecommerceapplication.controllers;

import com.bootcamp.project.ecommerceapplication.domain.Customer;
import com.bootcamp.project.ecommerceapplication.domain.Seller;
import com.bootcamp.project.ecommerceapplication.models.UserModel;
import com.bootcamp.project.ecommerceapplication.services.AdminService;
import com.bootcamp.project.ecommerceapplication.services.CustomerService;
import com.bootcamp.project.ecommerceapplication.services.SellerService;
import com.bootcamp.project.ecommerceapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    @Autowired
    AdminService adminService;

    @GetMapping("/getcustomers")
    public List<Customer> getCustomers() {
        return customerService.getList();
    }

    @GetMapping("/getsellers")
    public List<Seller> getSellers() {
        return sellerService.getList();
    }

    @PutMapping("/activate-customer/{user}")
    public ResponseEntity<String> activateCustomer(@PathVariable String user) {

        if (adminService.activate(user)) {
            return ResponseEntity.accepted().body("Customer activated");
        }
        return new ResponseEntity<>("customer not activated", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/activate-seller/{user}")
    public ResponseEntity<String> activateSeller(@PathVariable String user) {

        if (adminService.activate(user)) {
            return ResponseEntity.accepted().body("Seller activated");
        }
        return new ResponseEntity<>("seller not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/deactivate-customer/{user}")
    public ResponseEntity<String> deactivateCustomer(@PathVariable String user) {

        if (adminService.deactivate(user)) {
            return ResponseEntity.accepted().body("Customer deactivated");
        }
        return new ResponseEntity<>("customer not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/deactivate-seller/{user}")
    public ResponseEntity<String> deactivateSeller(@PathVariable String user) {

        if (adminService.deactivate(user)) {
            return ResponseEntity.accepted().body("Seller deactivated");
        }
        return new ResponseEntity<>("seller not found", HttpStatus.NOT_FOUND);
    }

}
