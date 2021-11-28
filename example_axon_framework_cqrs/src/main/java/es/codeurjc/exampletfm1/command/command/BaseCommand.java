package es.codeurjc.exampletfm1.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand {

	//The TargetAggregateIdentifier annotation tells Axon that the annotated field is an id of a given aggregate to which the command should be targeted.
	@TargetAggregateIdentifier
	private final String id;
	
	public BaseCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
