package com.example.demo.entities;

import java.math.BigInteger;

public class AccountFactory implements IAccountFactory{

	@Override
	public IAccount create(Integer id, BigInteger balance) {
		return new Account(id, balance);
	}

}
