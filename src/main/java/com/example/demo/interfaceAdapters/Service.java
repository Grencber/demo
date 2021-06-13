package com.example.demo.interfaceAdapters;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Service implements CommandLineRunner{

	@Autowired
	JpaAccountRepository accountRepo;

	@Autowired
	JpaCustomerRepository customerRepo;
	
	@Autowired
	JpaTransactionRepository transactionRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		AccountDataMapper account = new AccountDataMapper(1, new BigInteger("1000"));
		accountRepo.save(account);
		CustomerDataMapper customer = new CustomerDataMapper(10, "Emre", "Aytekin");
		customerRepo.save(customer);
		
	}

}
