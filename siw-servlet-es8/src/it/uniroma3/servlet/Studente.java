package it.uniroma3.servlet;

public class Studente {
	private String nome;
	private String cognome;
	private Integer matricola;

	
	public Studente(String nome, String cognome, Integer matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public Integer getMatricola() {
		return matricola;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	
	
}