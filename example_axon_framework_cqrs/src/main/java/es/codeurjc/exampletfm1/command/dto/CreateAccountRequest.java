package es.codeurjc.exampletfm1.command.dto;

public class CreateAccountRequest {

	Float initialDeposit;

	public CreateAccountRequest() {
		super();
	}
	
	public CreateAccountRequest(Float initialDeposit) {
		this.initialDeposit = initialDeposit;
	}
	
	public Float getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(Float initialDeposit) {
		this.initialDeposit = initialDeposit;
	}
}
