package es.codeurjc.exampletfm1.command.command;

public class DepositMoneyCommand extends BaseCommand {

	private Float amount;
	
	public DepositMoneyCommand(String id, Float amount) {
		super(id);
		this.amount = amount;
	}

	public Float getAmount() {
		return amount;
	}
}
