package it.corso.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.BigliettoDao;
import it.corso.dao.EventoDao;
import it.corso.dao.UtenteDao;
import it.corso.model.Biglietto;
import it.corso.model.Evento;

@Service
public class BigliettoServiceImpl implements BigliettoService {

	@Autowired
	private BigliettoDao bigliettoDao;
	
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private EventoService eventoService;
	
	
	@Override
	public void registraBiglietto(Object...dati) 
	{
		Biglietto biglietto= new Biglietto();
		String data = (String) dati[0];
		int idUtente = (int) dati[1];
		int idEvento = (int) dati[2];
	
		biglietto.setPrezzo(20.90);
		biglietto.setDataAcquisto(LocalDate.now());
		biglietto.setDataIngresso(LocalDate.parse(data));
		biglietto.setUtente(utenteService.getUtenteById(idUtente));
		Evento evento = eventoService.getEventoById(idEvento);
		biglietto.setEvento(evento);
		for (int i = 0; i < evento.getBiglietti().size(); i++) {
			System.out.println(evento.getBiglietti().get(i).getUtente().getUsername());
		}
		
		bigliettoDao.save(biglietto);
		
	}

	@Override
	public Biglietto getABigliettoById(int id) {
		return bigliettoDao.findById(id).get();
	}

	@Override
	public List<Biglietto> getBiglietto() {
		return (List<Biglietto>) bigliettoDao.findAll();
	}

	@Override
	public void cancellaBiglietto(Biglietto biglietto) {
		bigliettoDao.delete(biglietto);
	}

}
