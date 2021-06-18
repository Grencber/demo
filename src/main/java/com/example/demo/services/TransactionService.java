package com.example.demo.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.TransactionDataMapper;
import com.example.demo.interfaceAdapters.JpaTransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class TransactionService {
	
	@Autowired
	private JpaTransactionRepository jpaTransactionRepository;

	public void makeTransaction(Integer fromAccount, Integer toAccount,BigDecimal amount,Date dateOfTransaction) {
		jpaTransactionRepository.save(new TransactionDataMapper(null, toAccount, amount, dateOfTransaction));
    }
	
	public ArrayNode getAllTransactionsToAnAccountByCustomerId(List<Integer> customerIdList) {
		Iterable<TransactionDataMapper> transactions = jpaTransactionRepository.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.createArrayNode();
		for (int i = 0; i < customerIdList.size(); i++) {
			for (TransactionDataMapper transactionDataMapper : transactions) {
				ObjectNode objectNode = objectMapper.createObjectNode();
				int currentAccountTo = transactionDataMapper.getAccountTo();
				if (currentAccountTo == customerIdList.get(i)) {
					objectNode.put("id", transactionDataMapper.getId());
					objectNode.put("accountFrom", transactionDataMapper.getAccountFrom());
					objectNode.put("accountTo", transactionDataMapper.getAccountTo());
					objectNode.put("amount", transactionDataMapper.getAmount());
					objectNode.put("date", transactionDataMapper.getDate().getDate());
				}
				if (!objectNode.isEmpty()) {
					arrayNode.add(objectNode);
				}
			}
		}
		
		return arrayNode;
	}
}
