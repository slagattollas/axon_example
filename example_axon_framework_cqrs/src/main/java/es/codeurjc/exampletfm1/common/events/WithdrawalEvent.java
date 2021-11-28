package es.codeurjc.exampletfm1.common.events;

public class WithdrawalEvent extends BaseEvent {

	private final Float amount;
	
	public WithdrawalEvent(String id, Float amount) {
		super(id);
		this.amount = amount;
	}

	public Float getAmount() {
		return amount;
	}

}
