package com.example.demo;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Account;
import com.example.demo.entities.AccountFactory;
import com.example.demo.interfaceAdapters.AccountDataMapper;
import com.example.demo.interfaceAdapters.CustomerDataMapper;
import com.example.demo.interfaceAdapters.JpaAccountRepository;
import com.example.demo.interfaceAdapters.JpaCustomerRepository;
import com.example.demo.interfaceAdapters.JpaTransactionRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	JpaAccountRepository accountRepo;

	@Autowired
	JpaCustomerRepository customerRepo;
	
	@Autowired
	JpaTransactionRepository transactionRepo;
	
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
