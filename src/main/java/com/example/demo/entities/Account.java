package com.example.demo.entities;

import java.math.BigInteger;

public class Account implements IAccount{
	Integer id;
	BigInteger balance;

	public Account() {
	}
	
	public Account(Integer id, BigInteger balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public BigInteger getBalance() {
		return balance;
	}

}
