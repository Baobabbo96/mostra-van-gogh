package it.corso.service;

import java.util.List;

import it.corso.model.Biglietto;


public interface BigliettoService {

	void registraBiglietto(Biglietto biglietto);
	Biglietto getABigliettoById(int id);
	List<Biglietto> getBiglietto();
	void cancellaBiglietto(Biglietto biglietto);
}
