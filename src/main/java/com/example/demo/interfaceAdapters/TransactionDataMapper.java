package com.example.demo.interfaceAdapters;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionDataMapper {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer accountFrom;
	
	private Integer accountTo;
	
	private BigInteger amount;
	
	private Date date;
	
	public TransactionDataMapper() {

	}

	public TransactionDataMapper(Integer accountFrom, Integer accountTo, BigInteger amount, Date date) {
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(Integer accountFrom) {
		this.accountFrom = accountFrom;
	}

	public Integer getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(Integer accountTo) {
		this.accountTo = accountTo;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
	
	