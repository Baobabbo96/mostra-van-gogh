package it.corso.service;

import java.util.List;

import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

public interface UtenteService {

	void registraUtente(Utente utente);
	Utente getUtenteById(int id);
	List<Utente> getUtenti();
	boolean controlloLogin(HttpSession utente, String... credenziali);
	void cancellaUtente(Utente utente);
	List<Utente> getLastUtenti();
}
