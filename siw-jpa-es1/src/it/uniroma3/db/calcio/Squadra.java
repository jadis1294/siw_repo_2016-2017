package it.uniroma3.db.calcio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "findAllSquadre", query = "SELECT s FROM Squadra s")
public class Squadra {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	private String allenatore;
	
	@Temporal(TemporalType.DATE)
	private Date annoFondazione;
	
	//POLITICA DI FETCH
	//cambiata politica di fetch rispetto al default (per oneToMany è lazy)
	//poichè l'esercizio specifica che nella maggior parte dei casi d'uso quando viene richiesta una squaadra
	//si richiedono anche i dati dei giocatori, quindi conviene adottare una politica EAGER per caricarli subito
	
	//POLITICA DI CASCADE
	//dato che le operazioni sull'EM si applicano su una sola entità, invece di dover chiamare entrambe
	//le entità, ovviamente collegate, con la politica di cascade adottata una volta chiamata una operazione su 
	//squadra, quessta viene "estesa" anche su Giocatore, in cascata.Notare che le operazioni
	//che sono eseguite anche su giocatore in cascata sono Persist e Remove.
	
	
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name= "Squadra_id") //Serve per non creare una tabella per il join tra giocatore e squadra,//ma forma solo una colonna in piu nella tabella giocatore
	private List<Giocatore> giocatori;
	
	public Squadra(){
		this.giocatori=new ArrayList<Giocatore>();
	}
	
	//getter & setter//

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAllenatore() {
		return allenatore;
	}

	public void setAllenatore(String allenatore) {
		this.allenatore = allenatore;
	}

	public Date getAnnoFondazione() {
		return annoFondazione;
	}

	public void setAnnoFondazione(Date annoFondazione) {
		this.annoFondazione = annoFondazione;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}
}
