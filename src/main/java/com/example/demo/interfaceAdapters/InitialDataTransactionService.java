package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialDataTransactionService implements CommandLineRunner{

	@Autowired
	JpaAccountRepository accountRepo;

	@Autowired
	JpaCustomerRepository customerRepo;
	
	
	private static final Logger log = LoggerFactory.getLogger(InitialDataTransactionService.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CustomerDataMapper customer = new CustomerDataMapper("Emre", "Psycho");
		CustomerDataMapper savedCustomer = customerRepo.save(customer);
		
		log.info("Saved customer is {}", savedCustomer.getId());
		
		AccountDataMapper account = new AccountDataMapper(new BigDecimal("1000"),customer);
		AccountDataMapper savedAccount = accountRepo.save(account);
		log.info("Saved account id is {}", savedAccount.getId());
	}

}
