package it.uniroma3.oggetti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAll", query = "SELECT o FROM Opera o")
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String titolo;
	private Integer annoCreazione;
	private String tecnica;
	private Integer altezza;
	private Integer lunghezza;
	private Autore autore;
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getAnnoCreazione() {
		return annoCreazione;
	}
	public void setAnnoCreazione(Integer annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public Integer getAltezza() {
		return altezza;
	}
	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}
	public Integer getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(Integer lunghezza) {
		this.lunghezza = lunghezza;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public Long getId() {
		return id;
	}
	
	
}
