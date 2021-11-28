package es.codeurjc.exampletfm1.common.events;

public class AccountActivatedEvent extends BaseEvent {

	private String status;
	
	public AccountActivatedEvent(String id, String status) {
		super(id);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
