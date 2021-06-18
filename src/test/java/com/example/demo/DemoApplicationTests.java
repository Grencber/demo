package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.example.demo.exceptions.CustomerInputNotValidException;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.interfaceAdapters.Controller;
import com.example.demo.interfaceAdapters.CreateAccountRequestMapper;
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
	void testCreateAccountForExistingCustomerId() {
		CreateAccountRequestMapper createAccountRequestObject = new CreateAccountRequestMapper();
		createAccountRequestObject.setCustomerId(1);
		createAccountRequestObject.setInitialCredit(new BigDecimal(100));
		String actual = String.valueOf(controller.createAccount(createAccountRequestObject));
		assertEquals(actual, "<200 OK OK,[]>");
	}
	
	@Test
	void testCreateAccountForNonExistingCustomerIdFails() {
		CreateAccountRequestMapper createAccountRequestObject = new CreateAccountRequestMapper();
		createAccountRequestObject.setCustomerId(2);
		createAccountRequestObject.setInitialCredit(new BigDecimal(100));
		Throwable exception = assertThrows(CustomerNotFoundException.class, () -> controller.createAccount(createAccountRequestObject));
		assertEquals("Customer is not found", exception.getMessage());
	}
	
	@Test
	void testCreateAccountForNonValidCustomerIdFails() {
		CreateAccountRequestMapper createAccountRequestObject = new CreateAccountRequestMapper();
		createAccountRequestObject.setCustomerId(0);
		createAccountRequestObject.setInitialCredit(new BigDecimal(100));
		Throwable exception = assertThrows(CustomerInputNotValidException.class, () -> controller.createAccount(createAccountRequestObject));
		assertEquals("CustomerId 0 is not valid...", exception.getMessage());
	}
//	@Test
//	void testDB() {
//		CustomerDataMapper customer = new CustomerDataMapper(1, "Emre", "Aytekin");
//		customerRepo.save(customer);
//		AccountDataMapper account = new AccountDataMapper(10, new BigInteger("100,000"));
//		accountRepo.save(account);
//	}

}
