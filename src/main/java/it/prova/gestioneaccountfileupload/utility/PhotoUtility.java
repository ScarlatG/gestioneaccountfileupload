package it.prova.gestioneaccountfileupload.utility;

import java.util.Base64;

import it.prova.gestioneaccountfileupload.model.Account;

public class PhotoUtility {

	public static String getPhoto(Account account) {
		String base64Encoded = Base64.getEncoder().encodeToString(account.getFoto());
		return "data:image/jpeg;base64," + base64Encoded;

	}

}