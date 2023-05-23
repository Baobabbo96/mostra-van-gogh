package it.corso.service;

import java.util.List;

import it.corso.model.Biglietto;


public interface BigliettoService {

	void registraBiglietto(Object...Biglietto);
	Biglietto getABigliettoById(int id);
	List<Biglietto> getBiglietto();
	void eliminaBiglietto(Object...Biglietto);
}
