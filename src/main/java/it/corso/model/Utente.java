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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi")
	private String nome;
	
	@Column(name = "cognome")
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi")
	private String cognome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "indirizzo")
	@Pattern(regexp = "[a-zA-Z\\s'0-9]{1,150}", message = "Caratteri non ammessi")
	private String indirizzo;
	
	@Column(name = "comune")
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Caratteri non ammessi")
	private String comune;
	
	@Column(name = "provincia")
	@Pattern(regexp = "[a-zA-Z]{2}", message = "Caratteri non ammessi")
	private String provincia;
	
	@Column(name = "cap")
	@Pattern(regexp = "[0-9]{5}", message = "Caratteri non ammessi")
	private String cap;
	
	@Column(name = "username")
	@Pattern(regexp = "[a-zA-Z.]{1,20}", message = "Username non valido")
	private String username;
	
	@Column(name = "password")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}", message = "Password troppo debole")
	private String password;
	
	@OneToMany(
		mappedBy = "utente",
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER,
		orphanRemoval = true
			)
	private List<Ordine> ordini = new ArrayList<>();
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Ordine> getOrdini() {
		return ordini;
	}
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	
}
