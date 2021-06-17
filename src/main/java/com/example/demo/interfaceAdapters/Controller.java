package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerValidatorService customerIdValidatorService;

	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	@PostMapping("/createAccount")
	public ResponseEntity<AccountDataMapper> createAccount(
			@RequestBody CreateAccountRequestObject createAccountRequestObject) {

		customerIdValidatorService.validateCustomerId(createAccountRequestObject.getCustomerId());
		if (createAccountRequestObject.getInitialCredit().compareTo(new BigDecimal("0")) > 0) {
			log.info("Initial credit is bigger than 0");
		} else {
			log.info("Initial credit is not bigger than 0");
		}

		Integer openedAccountId = accountService.openNewAccount(createAccountRequestObject.getInitialCredit(),
				createAccountRequestObject.getCustomerId());
		transactionService.makeTransaction(null, openedAccountId, createAccountRequestObject.getInitialCredit(),
				new Date());

		return new ResponseEntity<AccountDataMapper>(HttpStatus.OK);
	}

}
