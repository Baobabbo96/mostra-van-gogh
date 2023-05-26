package it.corso.service;

import java.util.List;

import it.corso.model.Biglietto;


public interface BigliettoService {

	String registraBiglietto( Object...dati);
	Biglietto getABigliettoById(int id);
	List<Biglietto> getBiglietto();
	void cancellaBiglietto(Biglietto biglietto);
}
