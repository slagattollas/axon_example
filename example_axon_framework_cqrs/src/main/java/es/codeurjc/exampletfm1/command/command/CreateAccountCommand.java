package es.codeurjc.exampletfm1.command.command;

public class CreateAccountCommand extends BaseCommand {

	private Float balance;
	
	public CreateAccountCommand(String id, Float balance) {
		super(id);
		this.balance = balance;
	}

	public Float getBalance() {
		return balance;
	}

}
