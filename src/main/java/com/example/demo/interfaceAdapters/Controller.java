package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.AccountDataMapper;
import com.example.demo.services.AccountService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.CustomerValidatorService;
import com.example.demo.services.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
public class Controller {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerValidatorService customerIdValidatorService;
	
	@Autowired
	private CustomerService customerService;

	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	@PostMapping("/createAccount")
	public ResponseEntity<AccountDataMapper> createAccount(
			@RequestBody CreateAccountRequestMapper createAccountRequestObject) {

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
	
	@GetMapping("/retrieveCustomerInfo/{id}")
	public ResponseEntity<ObjectNode> getCustomerInfo(@PathVariable(value = "id") Integer customerId) {
		customerIdValidatorService.validateCustomerId(customerId);
		ObjectNode customerdata = customerService.findCustomerById(customerId);
		ArrayNode accountDataByCustomerId = accountService.getAllAccountsPartiallyByCustomer(customerId);
		customerdata.put("accounts", accountDataByCustomerId);
		List<Integer> accountToIds = accountService.getAllAccountIdsByCustomerId(customerId);
		ArrayNode transactionsByCustomerId = transactionService.getAllTransactionsToAnAccountByCustomerId(accountToIds);
		customerdata.put("transactions", transactionsByCustomerId);
		return new ResponseEntity<ObjectNode>(customerdata, HttpStatus.OK);
	}

}
