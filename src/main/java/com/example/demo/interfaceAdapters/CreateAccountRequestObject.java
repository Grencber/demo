package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;

public class CreateAccountRequestObject {

	private Integer customerId;
	
	private BigDecimal initialCredit;

	public CreateAccountRequestObject() {

	}
	
	public CreateAccountRequestObject(Integer customerId, BigDecimal initialCredit) {
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
