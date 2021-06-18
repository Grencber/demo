package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.AccountDataMapper;
import com.example.demo.interfaceAdapters.JpaAccountRepository;
import com.example.demo.interfaceAdapters.JpaCustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
	
	public ArrayNode getAllAccountsPartiallyByCustomer(Integer customerId) {
		
		Iterable<AccountDataMapper> iterable = jpaAccountRepository.findAll();
		List<AccountDataMapper> accountList = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.createArrayNode();
		for (AccountDataMapper accountDataMapper : iterable) {
			int currentAccountCustomerId = accountDataMapper.getCustomer().getId();
			ObjectNode objectNode = objectMapper.createObjectNode();
			if (currentAccountCustomerId == customerId) {
				objectNode.put("id", accountDataMapper.getId());
				objectNode.put("balance", accountDataMapper.getBalance());
			}
			arrayNode.add(objectNode);
		}
		
		return arrayNode;
	}
	
	public List<Integer> getAllAccountIdsByCustomerId(Integer customerId) {
		
		Iterable<AccountDataMapper> accountList = jpaAccountRepository.findAll();
		List<Integer> matchedAccountIds = new ArrayList<>();
		for (AccountDataMapper accountDataMapper : accountList) {
			int currentAccountCustomerId = accountDataMapper.getCustomer().getId();
			if (currentAccountCustomerId == customerId) {
				matchedAccountIds.add(accountDataMapper.getId());
			}
		}
		return matchedAccountIds;
	}
}
