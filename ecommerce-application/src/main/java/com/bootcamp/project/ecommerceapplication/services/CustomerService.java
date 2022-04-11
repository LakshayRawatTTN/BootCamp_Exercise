package com.bootcamp.project.ecommerceapplication.services;

import com.bootcamp.project.ecommerceapplication.domain.Customer;
import com.bootcamp.project.ecommerceapplication.domain.Role;
import com.bootcamp.project.ecommerceapplication.domain.Seller;
import com.bootcamp.project.ecommerceapplication.domain.User;
import com.bootcamp.project.ecommerceapplication.models.CustomerModel;
import com.bootcamp.project.ecommerceapplication.models.SellerModel;
import com.bootcamp.project.ecommerceapplication.repositories.CustomerRepository;
import com.bootcamp.project.ecommerceapplication.repositories.RoleRepository;
import com.bootcamp.project.ecommerceapplication.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public Customer addCustomer(CustomerModel customerModel){

        Customer customer = new Customer(customerModel);
        User user = new User();
        user.setEmail(customerModel.getEmail());
        user.setFirstName(customerModel.getFirstName());
        user.setMiddleName(customerModel.getMiddleName());
        user.setLastName(customerModel.getLastName());
        user.setPassword(passwordEncoder.encode(customerModel.getPassword()));
        List<Role> roles = roleRepository.findAllByIdIn(Arrays.asList(1L));
        user.setRoles(roles);
        customer.setUser(user);
        customerRepository.save(customer);

        return customer;

    }

    public List<Customer> getList(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

}
