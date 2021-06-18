package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;

public class CreateAccountRequestMapper {

	private Integer customerId;
	
	private BigDecimal initialCredit;

	public CreateAccountRequestMapper() {

	}
	
	public CreateAccountRequestMapper(Integer customerId, BigDecimal initialCredit) {
		this.customerId = customerId;
		this.initialCredit = initialCredit;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}
}
