package com.example.demo.interfaceAdapters;

import static org.mockito.Mockito.mockitoSession;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

@SpringBootTest
public class ControllerUnitTest {
	
	@Autowired
	Controller controller;
	
	@BeforeEach
	public void init() throws Exception {
		InitialDataTransactionService initialDataTransactionService = Mockito.mock(InitialDataTransactionService.class);
		initialDataTransactionService.run();
	}
	
	@Test
	public void testOpenSecondAccountForCustomer() {
		AccountService accountService = Mockito.mock(AccountService.class);
		CustomerValidatorService customerIdValidatorService = Mockito.mock(CustomerValidatorService.class);
		TransactionService transactionService = Mockito.mock(TransactionService.class);
		accountService.openNewAccount(new BigDecimal(15), 1);
	}
}
