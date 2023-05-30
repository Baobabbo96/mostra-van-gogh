package it.corso.service;

import java.util.List;

import it.corso.model.Biglietto;


public interface BigliettoService {

	String registraBiglietto( Object...dati);
	Biglietto getBigliettoById(int id);
	List<Biglietto> getBiglietto();
	void cancellaBiglietto(Biglietto biglietto);
	List<Biglietto> getLastBiglietto();
}
