package it.uniroma3.oggetti;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Utente {
	@Column (nullable = false)
	private String nome;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String nickname;
	@Column (nullable = false)
	private String password;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPassword() {
		return password;
	}
}
