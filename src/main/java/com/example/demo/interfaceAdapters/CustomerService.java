package com.example.demo.interfaceAdapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CustomerDataMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class CustomerService {
	
	@Autowired
	private JpaCustomerRepository jpaCustomerRepository;
	
	public ObjectNode findCustomerById(Integer customerId) {
		CustomerDataMapper customerDataMapper = jpaCustomerRepository.findById(customerId).get();
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.put("id", customerDataMapper.getId());
		objectNode.put("name", customerDataMapper.getName());
		objectNode.put("surname", customerDataMapper.getSurname());
		return objectNode;
	}
}
