package it.corso.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.dao.OperaDao;
import it.corso.model.Opera;

@Service
public class OperaServiceImpl implements OperaService {

	@Autowired
	private OperaDao operaDao;
	
	@Override
	public void registraOpera(Object... dati) 
	{
		Opera opera = new Opera();
		String titolo = (String) dati[0];
		opera.setTitolo(titolo);
		String descrizione = (String) dati[1];
		opera.setDescrizione(descrizione);
		MultipartFile immagine = (MultipartFile) dati[2];
		
		if (immagine != null && !immagine.isEmpty()) {
			try {
				String contentType = immagine.getContentType();
				opera.setImmagine("data:"  + contentType + ";base64," + Base64.getEncoder().encodeToString(immagine.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String tecnica = (String) dati[3];
		opera.setTecnica(tecnica);
		double prezzoStampa = (double) dati[4];
		opera.setPrezzoStampa(prezzoStampa);
		String anno = (String) dati[5];
		opera.setAnno(anno);
		operaDao.save(opera);
		
	}

	@Override
	public Opera getOperaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opera> getOpere() {
		return (List<Opera>) operaDao.findAll();
	}

	@Override
	public void cancellaOpera(Opera opera) {
		// TODO Auto-generated method stub

	}

}
