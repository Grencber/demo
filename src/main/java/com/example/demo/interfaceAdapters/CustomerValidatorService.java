package com.example.demo.interfaceAdapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CustomerInputNotValidException;
import com.example.demo.exceptions.CustomerNotFoundException;

@Service
public class CustomerValidatorService {
	
	@Autowired
	private JpaCustomerRepository jpaCustomerRepository;

	public void validateCustomerId(Integer customerId) {
		
		if (customerId == 0 || customerId == null) {
			throw new CustomerInputNotValidException("CustomerId " + customerId + " is not valid...");
		}
		if (!jpaCustomerRepository.existsById(customerId)) {
			throw new CustomerNotFoundException("Customer is not found");
		}
	}

}
