package it.uniroma3.servlet;

public class Studente {
	private String nome;
	private String cognome;
	private Integer matricola;

	public Studente(String nome,String cognome, Integer matricola) {
		// TODO Auto-generated constructor stub
		this.nome=nome;
		this.cognome=cognome;
		this.matricola=matricola;
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

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}
}
