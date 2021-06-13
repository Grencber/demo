package com.example.demo.interfaceAdapters;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "account")
public class AccountDataMapper {
    @Id
    @GeneratedValue
    Integer id;

    BigInteger balance;

    @ManyToOne(fetch = FetchType.LAZY)
    CustomerDataMapper customer;

    public AccountDataMapper() {
    }

    public AccountDataMapper(BigInteger balance, CustomerDataMapper customerDataMapper) {
        this.balance = balance;
        this.customer = customerDataMapper;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

	public CustomerDataMapper getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDataMapper customer) {
		this.customer = customer;
	}
    
    
}

