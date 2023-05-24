package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.OrdineDao;
import it.corso.model.Ordine;

@Service
public class OrdineServiceImpl implements OrdineService {
	@Autowired
	private OrdineDao ordineDao;

	@Override
	public void registraOrdine(Ordine ordine, Object... dati) {
		// TODO Auto-generated method stub

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
