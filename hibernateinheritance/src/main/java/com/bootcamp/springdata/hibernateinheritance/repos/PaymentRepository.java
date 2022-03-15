package com.bootcamp.springdata.hibernateinheritance.repos;

import com.bootcamp.springdata.hibernateinheritance.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
