package es.codeurjc.exampletfm1.command.command;

public class WithdrawMoneyCommand extends BaseCommand {

	private Float amount;
	
	public WithdrawMoneyCommand(String id, Float amount) {
		super(id);
		this.amount = amount;
	}

	public Float getAmount() {
		return amount;
	}
}

