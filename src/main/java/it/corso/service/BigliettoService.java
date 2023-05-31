package it.corso.service;

import java.util.List;

import it.corso.model.Biglietto;
import it.corso.model.Utente;


public interface BigliettoService {

	String registraBiglietto(Object...dati);
	Biglietto getBigliettoById(int id);
	List<Biglietto> getBiglietto();
	void cancellaBiglietto(Biglietto biglietto);
	List<Biglietto> getLastBiglietto();
	List<Biglietto> getBigliettobyUtente(Utente utente);
}
