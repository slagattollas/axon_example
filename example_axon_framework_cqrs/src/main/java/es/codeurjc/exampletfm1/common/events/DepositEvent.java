package es.codeurjc.exampletfm1.common.events;

public class DepositEvent extends BaseEvent {

	private final Float amount;
	
	public DepositEvent(String id, Float amount) {
		super(id);
		this.amount = amount;
	}

	public Float getAmount() {
		return amount;
	}

}
