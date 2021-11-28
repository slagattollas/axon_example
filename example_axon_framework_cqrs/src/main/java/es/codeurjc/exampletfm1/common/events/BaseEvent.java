package es.codeurjc.exampletfm1.common.events;


public class BaseEvent {

	private final String id;
	
	public BaseEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
