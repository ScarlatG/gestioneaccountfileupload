package it.prova.gestioneaccountfileupload.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import it.prova.gestioneaccountfileupload.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataCreazione;

	private byte[] foto;

	public Account buildModelFromDTO() {
		return new Account(this.getId(), this.getNome(), this.getCognome(), this.getEmail(), this.getDataCreazione(),
				this.getFoto());
	}

	public static AccountDTO buildAccountDTOFromModel(Account accountModel) {
		AccountDTO result = new AccountDTO(accountModel.getId(), accountModel.getNome(), accountModel.getCognome(),
				accountModel.getEmail(), accountModel.getDataCreazione(), accountModel.getFoto());
		return result;
	}

	public static List<AccountDTO> createAccountDTOListFromModelList(List<Account> modelListInput) {
		return modelListInput.stream()
				.map(accountItem -> new AccountDTO(accountItem.getId(), accountItem.getNome(), accountItem.getCognome(),
						accountItem.getEmail(), accountItem.getDataCreazione(), accountItem.getFoto()))
				.collect(Collectors.toList());

	}
}
