package it.corso.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.BigliettoDao;
import it.corso.dao.EventoDao;
import it.corso.dao.UtenteDao;
import it.corso.model.Biglietto;
import jakarta.servlet.http.HttpSession;

@Service
public class BigliettoServiceImpl implements BigliettoService {

	@Autowired
	private BigliettoDao bigliettoDao;
	
	
	@Autowired
	private UtenteDao utenteDao;
	
	@Autowired
	private EventoDao eventoDao;
	
	
	@Override
	public void registraBiglietto(
			Object...dati) {
		Biglietto biglietto= new Biglietto();
		String data = (String) dati[0];
		int idUtente = (int) dati[1];
		int idEvento = (int) dati[2];
	
		biglietto.setPrezzo(20.90);
		biglietto.setDataAcquisto(LocalDate.now());
		biglietto.setDataIngresso(LocalDate.parse(data));
		biglietto.setUtente(utenteDao.findById(idUtente).get());
		biglietto.setEvento(eventoDao.findById(idEvento).get());
		
		bigliettoDao.save(biglietto);
		
	}

	@Override
	public Biglietto getABigliettoById(int id) {
		return null;
	}

	@Override
	public List<Biglietto> getBiglietto() {
		return null;
	}

	@Override
	public void cancellaBiglietto(Biglietto biglietto) {

	}

}
