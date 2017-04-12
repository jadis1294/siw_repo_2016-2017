package it.uniroma3.db.azienda;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Divisione {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	private String descrizione;
	@OneToMany(mappedBy= "divisione")
	private List<Impiegato> impiegati;
	
	public Divisione(){
		this.impiegati=new ArrayList<Impiegato>();
	}
	
	//getter & setter
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<Impiegato> getImpiegati() {
		return impiegati;
	}
	public void setImpiegati(List<Impiegato> impiegati) {
		this.impiegati = impiegati;
	}
	
}
