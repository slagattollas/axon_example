package es.codeurjc.exampletfm1.command.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.exampletfm1.command.dto.CreateAccountRequest;
import es.codeurjc.exampletfm1.command.dto.CreateDepositRequest;
import es.codeurjc.exampletfm1.command.dto.CreateWithdrawRequest;
import es.codeurjc.exampletfm1.command.service.AccountCommandService;

@RestController
public class AccountCommandController {

	private AccountCommandService accountCommandService;
	
	public AccountCommandController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }
	
	@PostMapping(value = "/create")
    public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest request) {
        try {
            CompletableFuture<String> response =
            		accountCommandService.createAccount(request);

            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@PutMapping(value = "/deposit")
    public ResponseEntity<String> deposit(@RequestBody CreateDepositRequest request) {
        try {
            accountCommandService.depositToAccount(request);

            return new ResponseEntity<>("Amount credited", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody CreateWithdrawRequest request) {
        try {
            accountCommandService.withdrawFromAccount(request);

            return new ResponseEntity<>("Amount debited.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
