package it.prova.gestioneaccountfileupload.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestioneaccountfileupload.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
