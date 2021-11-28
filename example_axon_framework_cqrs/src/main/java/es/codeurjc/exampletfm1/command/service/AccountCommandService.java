package es.codeurjc.exampletfm1.command.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import es.codeurjc.exampletfm1.command.command.CreateAccountCommand;
import es.codeurjc.exampletfm1.command.command.DepositMoneyCommand;
import es.codeurjc.exampletfm1.command.command.WithdrawMoneyCommand;
import es.codeurjc.exampletfm1.command.dto.CreateAccountRequest;
import es.codeurjc.exampletfm1.command.dto.CreateDepositRequest;
import es.codeurjc.exampletfm1.command.dto.CreateWithdrawRequest;

@Service
public class AccountCommandService {

	private final CommandGateway commandGateway;
	
	public AccountCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
	
	public CompletableFuture<String> createAccount(CreateAccountRequest createAccountRequest) {
		
		return this.commandGateway.send(
				new CreateAccountCommand(UUID.randomUUID().toString(), createAccountRequest.getInitialDeposit())
				);
		
	}
	
	public CompletableFuture<String> withdrawFromAccount(CreateWithdrawRequest createWithdrawRequest) {
		return this.commandGateway.send(
				new WithdrawMoneyCommand(createWithdrawRequest.getAccountId(), createWithdrawRequest.getAmount())
				);
		
	}
	
	public CompletableFuture<String> depositToAccount(CreateDepositRequest createDepositRequest) {
		return this.commandGateway.send(
				new DepositMoneyCommand(createDepositRequest.getAccountId(), createDepositRequest.getAmount())
				);
		
	}
	
}
