package it.uniroma3.db.azienda;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Impiegato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cognome;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	@Column(nullable=false)
	private String matricola;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Progetto progetto;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Divisione divisione;
	
	
	public Impiegato() {
	}
	
	
	//getter & setter//
	public Long getId() {
		return id;
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Progetto getProgetto() {
		return progetto;
	}

	public void setProgetto(Progetto progetto) {
		this.progetto = progetto;
	}
	
}
