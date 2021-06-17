package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	@Autowired
	private JpaTransactionRepository jpaTransactionRepository;

	public void makeTransaction(Integer fromAccount, Integer toAccount,BigDecimal amount,Date dateOfTransaction) {
		jpaTransactionRepository.save(new TransactionDataMapper(null, toAccount, amount, dateOfTransaction));
    }
}
