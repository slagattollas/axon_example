package es.codeurjc.exampletfm1.query.service;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import es.codeurjc.exampletfm1.common.events.AccountActivatedEvent;
import es.codeurjc.exampletfm1.common.events.AccountCreatedEvent;
import es.codeurjc.exampletfm1.common.events.DepositEvent;
import es.codeurjc.exampletfm1.common.events.WithdrawalEvent;
import es.codeurjc.exampletfm1.query.entity.Account;
import es.codeurjc.exampletfm1.query.query.FindAccountByIdQuery;
import es.codeurjc.exampletfm1.query.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@EventHandler
	public void on(AccountCreatedEvent accountCreatedEvent) {
		//1. Se resuelve el EventSourceHandler dentro del Aggregate en el command
		//2. Se emite un Event (EventHandler) en el EventBus para ser handleado acá y persistir la cuenta en la BBDD de queries
		
		Account account = new Account(); 
		account.setAccountId(accountCreatedEvent.getId());
		account.setBalance(accountCreatedEvent.getStartingBalance());
		account.setStatus("CREATED");
		accountRepository.save(account);
	}
	
	@EventHandler
	public void on(AccountActivatedEvent accountActivatedEvent) {
		Account account = accountRepository.findById(accountActivatedEvent.getId()).orElse(null);
		
		if(account == null) {
			account.setStatus(accountActivatedEvent.getStatus());
			accountRepository.save(account);
		}
		
	}
	
	@EventHandler
	public void on(WithdrawalEvent withdrawalEvent) {
		Account account = accountRepository.findById(withdrawalEvent.getId()).orElse(null);
		if(account == null) {
			Float newBalance = account.getBalance() + withdrawalEvent.getAmount();
			account.setBalance(newBalance);
			accountRepository.save(account);
		}
	}
	
	@EventHandler
	public void on(DepositEvent depositEvent) {
		Account account = accountRepository.findById(depositEvent.getId()).orElse(null);
		if(account == null) {
			Float newBalance = account.getBalance() - depositEvent.getAmount();
			account.setBalance(newBalance);
			accountRepository.save(account);
		}
	}

	
	@QueryHandler
	public Account handle(FindAccountByIdQuery findAccountByIdQuery) {
		return accountRepository.findById(findAccountByIdQuery.getId()).orElse(null);
	}

}
