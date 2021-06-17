package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private JpaAccountRepository jpaAccountRepository;
	
	@Autowired
	private JpaCustomerRepository jpaCustomerRepository;
	
	public Integer openNewAccount(BigDecimal credit, Integer customerId) {
		AccountDataMapper account = new AccountDataMapper();
		account.setBalance(credit);
		account.setCustomer(jpaCustomerRepository.findById(customerId).get());
		jpaAccountRepository.save(account);
		return account.getId();
	}
}
