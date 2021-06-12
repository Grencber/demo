package com.example.demo.entities;

import java.math.BigInteger;

public interface IAccountFactory {
	IAccount create(Integer id, BigInteger balance);
}
