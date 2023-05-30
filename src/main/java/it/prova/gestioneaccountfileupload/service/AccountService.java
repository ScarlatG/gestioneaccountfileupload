package it.prova.gestioneaccountfileupload.service;

import java.util.List;

import it.prova.gestioneaccountfileupload.model.Account;

public interface AccountService {

	public List<Account> listAllElements();

	public Account caricaSingoloElemento(Long id);

	public void aggiorna(Account entityInstance);

	public void inserisciNuovo(Account entityInstance);

	public void rimuoviById(Long idToRemove);
}
