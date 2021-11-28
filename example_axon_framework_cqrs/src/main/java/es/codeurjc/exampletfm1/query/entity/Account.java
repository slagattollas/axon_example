package es.codeurjc.exampletfm1.query.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	

	@Id
	private String accountId;
	
	private Float balance;
	
	private String status;
	
	public Account() {
	}
	
	public Account(String accountId, Float balance, String status) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
	}

	public String getAccountId() {
		return accountId;
	}

	public Float getBalance() {
		return balance;
	}

	public String getStatus() {
		return status;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
