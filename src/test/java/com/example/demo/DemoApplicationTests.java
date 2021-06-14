package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.interfaceAdapters.JpaAccountRepository;
import com.example.demo.interfaceAdapters.JpaCustomerRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	JpaAccountRepository accountRepo;

	@Autowired
	JpaCustomerRepository customerRepo;
	
	@Test
	void contextLoads() {
	}
	
//	@Test
//	void testDB() {
//		CustomerDataMapper customer = new CustomerDataMapper(1, "Emre", "Aytekin");
//		customerRepo.save(customer);
//		AccountDataMapper account = new AccountDataMapper(10, new BigInteger("100,000"));
//		accountRepo.save(account);
//	}

}
