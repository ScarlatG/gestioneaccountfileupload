package it.prova.gestioneaccountfileupload.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneaccountfileupload.model.Account;
import it.prova.gestioneaccountfileupload.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Account> listAllElements() {
		return (List<Account>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Account caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void aggiorna(Account entityInstance) {
		repository.save(entityInstance);

	}

	@Override
	@Transactional
	public void inserisciNuovo(Account entityInstance) {
		entityInstance.setDataCreazione(LocalDate.now());
		repository.save(entityInstance);
	}

	@Override
	@Transactional
	public void rimuoviById(Long idToRemove) {
		repository.deleteById(idToRemove);
	}

}
