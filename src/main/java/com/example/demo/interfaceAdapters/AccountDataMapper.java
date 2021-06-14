package com.example.demo.interfaceAdapters;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountDataMapper {
    @Id
    @GeneratedValue
    Integer id;

    BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    CustomerDataMapper customer;

    public AccountDataMapper() {
    }

    public AccountDataMapper(BigDecimal balance, CustomerDataMapper customerDataMapper) {
        this.balance = balance;
        this.customer = customerDataMapper;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public CustomerDataMapper getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDataMapper customer) {
		this.customer = customer;
	}
    
    
}

