package es.codeurjc.exampletfm1.common.events;

public class AccountCreatedEvent extends BaseEvent {

	private final Float startingBalance;
	
	public AccountCreatedEvent(String id, Float startingBalance) {
		super(id);
		this.startingBalance = startingBalance;
	}

	public Float getStartingBalance() {
		return startingBalance;
	}

}
