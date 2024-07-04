package it.ashyzan.pizzeria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class PizzaModel {
	
	/*
	 * - un nome
	 * - una descrizione
	 * - una foto (url)
	 * - un prezzo
	 * 
	 * */
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private Integer id;
	
	@Column(name = "nome", nullable = false , unique = true)
	private String nome;
	
	@Column(name = "descrizione", nullable = false)
	private String descrizione;
	
	@Column(name = "foto_url", nullable = true)
	private String fotoUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	
	

}
