package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.exceptions.CustomerInputNotValid;
import com.example.demo.exceptions.CustomerNotFoundException;

@RestController
public class Controller {
	
	@Autowired
	JpaAccountRepository accountRepo;

	@Autowired
	JpaCustomerRepository customerRepo;
	
	@Autowired
	JpaTransactionRepository transactionRepo;
	
//	@Autowired
//	TransactionService transactionService;
	
	private static final Logger log = LoggerFactory.getLogger(Controller.class);
	
	@GetMapping("/createAccount/{customerId}/initialCredit/{initialCredit}")
	public ResponseEntity<Account> createAccount(@PathVariable("customerId") Integer customerId,
												 @PathVariable("initialCredit") BigDecimal initialCredit) {
		if (customerId == 0 || customerId == null) {
			throw new CustomerInputNotValid("CustomerId " + customerId + " is not valid...");
		}
		
		if (!customerRepo.existsById(customerId)) {
			throw new CustomerNotFoundException("Customer is not found");
		}
		
		if (initialCredit.compareTo(new BigDecimal("0")) > 0) {
			log.info("Initial credit is bigger than 0");
		} else {
			log.info("Initial credit is not bigger than 0");
		}
	
		AccountDataMapper account = new AccountDataMapper();
		account.setBalance(initialCredit);
		account.setCustomer(customerRepo.findById(customerId).get());
		accountRepo.save(account);
		transactionRepo.save(new TransactionDataMapper(null, account.getId(), initialCredit, new Date()));
//		transactionService.saveTransaction();

		return null;
	}

}
