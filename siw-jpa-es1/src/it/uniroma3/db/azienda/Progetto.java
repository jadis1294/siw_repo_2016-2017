package it.uniroma3.db.azienda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Progetto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	
	@OneToMany
	@JoinColumn(name="progetto_id")
	private List<Impiegato> impiegati;

	
	public Progetto() {
		this.impiegati=new ArrayList<Impiegato>();
	}
	
	//getter&setter//
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public List<Impiegato> getImpiegati() {
		return impiegati;
	}

	public void setImpiegati(List<Impiegato> impiegati) {
		this.impiegati = impiegati;
	}
}
