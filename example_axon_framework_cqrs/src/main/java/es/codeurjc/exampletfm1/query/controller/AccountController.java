package es.codeurjc.exampletfm1.query.controller;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.exampletfm1.query.entity.Account;
import es.codeurjc.exampletfm1.query.query.FindAccountByIdQuery;

@RestController
public class AccountController  {

	private QueryGateway queryGateway;
	
	public AccountController(QueryGateway queryGateway) {
		super();
		this.queryGateway = queryGateway;
	}
	
	@GetMapping("/get_balance")
    public ResponseEntity<Account> getAccount(@RequestParam String id) {
        Account account = queryGateway.query(
                new FindAccountByIdQuery(id), Account.class
        ).join();

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
	
}
