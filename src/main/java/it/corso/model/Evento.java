package it.corso.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventi")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "data_inizio")
	private LocalDate dataInizio;
	
	@Column(name = "data_fine")
	private LocalDate dataFine;
	
	@OneToMany(
			mappedBy = "evento",
			cascade = CascadeType.ALL,
		    fetch = FetchType.EAGER,
		    orphanRemoval = true)
	private List<Biglietto> biglietti = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	public List<Biglietto> getBiglietti() {
		return biglietti;
	}
	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}
	
}
