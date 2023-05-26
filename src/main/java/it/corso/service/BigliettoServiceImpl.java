package it.corso.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.BigliettoDao;
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
			if (getBiglietto().get(i).getUtente().getId() == idUtente) {
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
