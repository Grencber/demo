package com.example.demo.interfaceAdapters;

import java.math.BigInteger;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(Service.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CustomerDataMapper customer = new CustomerDataMapper("Emre", "Aytekin");
		CustomerDataMapper savedCustomer = customerRepo.save(customer);
		
		log.info("Saved customer is {}", savedCustomer.getId());
		
		AccountDataMapper account = new AccountDataMapper(new BigInteger("1000"),customer);
		AccountDataMapper savedAccount = accountRepo.save(account);
		log.info("Saved account id is {}", savedAccount.getId());
	}

}
