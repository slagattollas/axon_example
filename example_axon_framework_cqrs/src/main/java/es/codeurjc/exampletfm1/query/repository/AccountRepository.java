package es.codeurjc.exampletfm1.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.exampletfm1.query.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
