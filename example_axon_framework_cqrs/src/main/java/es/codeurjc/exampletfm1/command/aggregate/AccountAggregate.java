package es.codeurjc.exampletfm1.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import es.codeurjc.exampletfm1.command.command.CreateAccountCommand;
import es.codeurjc.exampletfm1.command.command.DepositMoneyCommand;
import es.codeurjc.exampletfm1.command.command.WithdrawMoneyCommand;
import es.codeurjc.exampletfm1.common.events.AccountActivatedEvent;
import es.codeurjc.exampletfm1.common.events.AccountCreatedEvent;
import es.codeurjc.exampletfm1.common.events.DepositEvent;
import es.codeurjc.exampletfm1.common.events.WithdrawalEvent;

@Aggregate
public class AccountAggregate {

	@AggregateIdentifier
	private String accountId;
	private Float balance;
	private String status;
	
	public AccountAggregate() {
    }

	public String getAccountId() {
		return accountId;
	}

	public Float getBalance() {
		return balance;
	}

	public String getStatus() {
		return status;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getBalance()));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent accountCreatedEvent) {
        this.accountId = accountCreatedEvent.getId();
        this.balance = accountCreatedEvent.getStartingBalance();
        this.status = "CREATED";

        AggregateLifecycle.apply(new AccountActivatedEvent(this.accountId, "ACTIVATED"));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent accountActivatedEvent) {
        this.status = accountActivatedEvent.getStatus();
    }

    @CommandHandler
    public void on(DepositMoneyCommand depositMoneyCommand) {
        AggregateLifecycle.apply(new WithdrawalEvent(
                depositMoneyCommand.getId(),
                depositMoneyCommand.getAmount()));
    }

    @EventSourcingHandler
    public void on(WithdrawalEvent withdrawalEvent) {
        this.balance = this.balance + withdrawalEvent.getAmount();
    }

    @CommandHandler
    public void on(WithdrawMoneyCommand withdrawMoneyCommand) {
        AggregateLifecycle.apply(new DepositEvent(
                withdrawMoneyCommand.getId(),
                withdrawMoneyCommand.getAmount()));
    }

    @EventSourcingHandler
    public void on(DepositEvent depositEvent) {
        this.balance = this.balance - depositEvent.getAmount();
    }
}
