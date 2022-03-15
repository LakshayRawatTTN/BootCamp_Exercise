package com.bootcamp.springdata.hibernateinheritance;

import com.bootcamp.springdata.hibernateinheritance.entities.Check;
import com.bootcamp.springdata.hibernateinheritance.entities.CreditCard;
import com.bootcamp.springdata.hibernateinheritance.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateinheritanceApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testPaymentByCreditCard(){
		CreditCard cc = new CreditCard();
		cc.setId(3);
		cc.setAmount(1000);
		cc.setCardnumber("23456789564");
		paymentRepository.save(cc);
	}

	@Test
	public void testPaymentByCheck(){
		Check ch = new Check();
		ch.setId(2);
		ch.setAmount(20000);
		ch.setChecknumber("6785987654");
		paymentRepository.save(ch);
	}


}
