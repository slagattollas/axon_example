package es.codeurjc.exampletfm1.command.dto;

public class CreateWithdrawRequest {
	
	private String accountId;
	private Float amount;
	
	public CreateWithdrawRequest(String accountId, Float amount) {
		this.accountId = accountId;
		this.amount = amount;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
