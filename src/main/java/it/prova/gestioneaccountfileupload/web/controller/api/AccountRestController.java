package it.prova.gestioneaccountfileupload.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneaccountfileupload.dto.AccountDTO;
import it.prova.gestioneaccountfileupload.model.Account;
import it.prova.gestioneaccountfileupload.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public List<AccountDTO> getAll() {
		return AccountDTO.createAccountDTOListFromModelList(accountService.listAllElements());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AccountDTO createNew(@RequestBody AccountDTO accountDTO) {
		Account accountTransient = accountDTO.buildModelFromDTO();
		accountService.inserisciNuovo(accountTransient);
		return AccountDTO.buildAccountDTOFromModel(accountTransient);
	}

	@PutMapping("/edit/{idAccount}")
	public AccountDTO edit(@RequestBody AccountDTO accountDTO, @PathVariable(required = true) Long idAccount) {
		Account accountTransient = accountDTO.buildModelFromDTO();
		accountTransient.setId(idAccount);
		accountService.aggiorna(accountTransient);
		return AccountDTO.buildAccountDTOFromModel(accountTransient);

	}
}
