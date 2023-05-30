package it.prova.gestioneaccountfileupload.web.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.gestioneaccountfileupload.dto.AccountDTO;
import it.prova.gestioneaccountfileupload.service.AccountService;
import it.prova.gestioneaccountfileupload.utility.PhotoUtility;

@Controller
@RequestMapping(value = { "", "/account" })
public class AccountController {

	@Autowired
	private AccountService accountService;

	private static final String[] ALLOWED_MIME_TYPES = { "image/jpeg", "image/png", "image/gif" };

	@GetMapping
	public ModelAndView listAll() {
		List<AccountDTO> result = AccountDTO.createAccountDTOListFromModelList(accountService.listAllElements());
		return new ModelAndView("account/list", "account_list_attribute", result);
	}

	@GetMapping("/insert")
	public String createNew(Model model) {
		model.addAttribute("account_richiesta_permesso_attr", new AccountDTO());
		return "account/insert";
	}

	@PostMapping("/save")
	public String saveNewEntry(@RequestParam("file") MultipartFile file, AccountDTO account, Model model,
			RedirectAttributes redirectAttrs) {

		// la validazione è realizzata 'alla buona', in un progetto serio andrebbe
		// sistemata
		if (file == null || file.isEmpty() || account.getNome().isBlank()) {
			model.addAttribute("errorMessage", "Inserire dei valori");
			return "account/insert";
		}

		// Verifica il MIME type del file allegato
		String mimeType = file.getContentType();
		if (!Arrays.asList(ALLOWED_MIME_TYPES).contains(mimeType)) {
			model.addAttribute("errorMessage",
					"Tipo di file non supportato. Sono consentiti solo file JPEG, PNG e GIF.");
			return "account/insert";
		}

		try {
			account.setFoto(file.getBytes());
			account.setDataCreazione(LocalDate.now());
		} catch (IOException e) {
			throw new RuntimeException("Problema nell'upload della foto", e);
		}

		accountService.inserisciNuovo(account.buildModelFromDTO());

		redirectAttrs.addFlashAttribute("successMessage", "Operazione eseguita correttamente");
		return "redirect:/account";
	}

//	@GetMapping("/showAccount/{idAccount}")
//	public ResponseEntity<byte[]> showAccount(@PathVariable(required = true) Long idAccount) {
//
//		AccountDTO file = AccountDTO.buildAccountDTOFromModel(accountService.caricaSingoloElemento(idAccount));
//
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "account; filename=\"" + file.getNome() + "\"")
//				.body(file.getFoto());
//
//	}

	@GetMapping("/show/{idAccount}")
	public String showAccount(@PathVariable(required = true) Long idAccount, Model model) {
		String photo = PhotoUtility.getPhoto(accountService.caricaSingoloElemento(idAccount));

		model.addAttribute("show_account_attr",
				AccountDTO.buildAccountDTOFromModel(accountService.caricaSingoloElemento(idAccount)));
		model.addAttribute("photo", photo);
		return "account/show";
	}

}
