package it.corso.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "opere")
public class Opera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "immagine")
	private String immagine;

	@Column(name = "tecnica")
	private String tecnica;

	@Column(name = "prezzo_stampa")
	private double prezzoStampa;

	@Column(name="anno_realizzazione")
	private String anno;

	@ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
	@JoinTable(
		name = "carrello",
		joinColumns = @JoinColumn(name = "id_opera", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_ordine", referencedColumnName = "id")
			)
	private List<Ordine> ordini = new ArrayList<>();


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public double getPrezzoStampa() {
		return prezzoStampa;
	}
	public void setPrezzoStampa(double prezzoStampa) {
		this.prezzoStampa = prezzoStampa;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public List<Ordine> getOrdini() {
		return ordini;
	}
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}


}
