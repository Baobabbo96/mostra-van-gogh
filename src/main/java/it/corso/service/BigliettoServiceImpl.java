package it.corso.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.BigliettoDao;
import it.corso.model.Biglietto;
import it.corso.model.Evento;
import it.corso.model.Utente;

@Service
public class BigliettoServiceImpl implements BigliettoService {

	@Autowired
	private BigliettoDao bigliettoDao;
	
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private EventoService eventoService;
	
	
	@Override
	public String registraBiglietto(Object...dati) 
	{
		Biglietto biglietto= new Biglietto();
		String data = (String) dati[0];
		int idUtente = (int) dati[1];
		int idEvento = (int) dati[2];
		Evento evento = eventoService.getEventoById(idEvento);
		LocalDate dataIngresso = LocalDate.parse(data);
		
		if (dataIngresso.isBefore(evento.getDataInizio()) || 
			dataIngresso.isAfter(evento.getDataFine())) 
		{
			return "data";
		}
		
		for (int i = 0; i < getBiglietto().size(); i++) {
			if (getBiglietto().get(i).getUtente().getId() == idUtente && 
					getBiglietto().get(i).getEvento().getId() == idEvento) {
				return "biglietto";
			}
		}

		biglietto.setPrezzo(20.90);
		biglietto.setDataAcquisto(LocalDate.now());
		biglietto.setDataIngresso(dataIngresso);
		biglietto.setUtente(utenteService.getUtenteById(idUtente));
		biglietto.setEvento(evento);
		bigliettoDao.save(biglietto);
		return "save";
		
	}

	@Override
	public Biglietto getBigliettoById(int id) {
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

	@Override
	public List<Biglietto> getLastBiglietto() {
		return bigliettoDao.getLastBiglietto();
	}

	@Override
	public List<Biglietto> getBigliettobyUtente(Utente utente) {
		List<Biglietto> biglietti = (List<Biglietto>) bigliettoDao.findAll();
		List<Biglietto> bigliettiUtente = new ArrayList<Biglietto>();
		for (Biglietto biglietto : biglietti) {
			if (biglietto.getUtente().getId() == utente.getId()) {
				bigliettiUtente.add(biglietto);
			}
		}
		return bigliettiUtente;
	}

}
