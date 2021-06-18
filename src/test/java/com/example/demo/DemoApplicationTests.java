package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.example.demo.domain.CreateAccountRequestMapper;
import com.example.demo.interfaceAdapters.Controller;
import com.example.demo.interfaceAdapters.JpaAccountRepository;
import com.example.demo.interfaceAdapters.JpaCustomerRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	JpaAccountRepository accountRepo;

	@Autowired
	JpaCustomerRepository customerRepo;
	
	@Autowired
	Controller controller;
	
	@Test
	void contextLoads() {
		CreateAccountRequestMapper createAccountRequestObject = new CreateAccountRequestMapper();
		createAccountRequestObject.setCustomerId(1);
		createAccountRequestObject.setInitialCredit(new BigDecimal(100));
		String actual = String.valueOf(controller.createAccount(createAccountRequestObject));
		assertEquals(actual, "<200 OK OK,[]>");
	}
	
//	@Test
//	void testDB() {
//		CustomerDataMapper customer = new CustomerDataMapper(1, "Emre", "Aytekin");
//		customerRepo.save(customer);
//		AccountDataMapper account = new AccountDataMapper(10, new BigInteger("100,000"));
//		accountRepo.save(account);
//	}

}
