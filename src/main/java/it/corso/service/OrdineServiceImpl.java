package it.corso.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.OrdineDao;
import it.corso.model.Opera;
import it.corso.model.Ordine;
import it.corso.model.Utente;

@Service
public class OrdineServiceImpl implements OrdineService {
	
	@Autowired
	private OrdineDao ordineDao;
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private OperaService operaService;

	@Override
	public void registraOrdine(Ordine ordine, Object... dati) 
	{
		int idUtente = (int) dati[0];
		int[] idOpere = (int[]) dati[1];
		ordine.setData(LocalDate.now());
		Utente utente = utenteService.getUtenteById(idUtente);
		ordine.setUtente(utente);
		for(int idOpera : idOpere)
		{
			Opera opera = operaService.getOperaById(idOpera);
			ordine.getOpere().add(opera);
		}
		double importo = 0;
		for(Opera o : ordine.getOpere())
			importo += o.getPrezzoStampa();
		ordine.setImporto(importo);
		
		ordineDao.save(ordine);	
	}

	@Override
	public Ordine getOrdineById(int id) {
		// TODO Auto-generated method stub
		return ordineDao.findById(id).get();
	}

	@Override
	public List<Ordine> getOrdini() {
		return (List<Ordine>) ordineDao.findAll();
	}

	@Override
	public void cancellaOrdine(Ordine ordine) {
		ordineDao.delete(ordine);

	}

}
