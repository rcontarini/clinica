package br.com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Perfil extends GenericModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3341563212295549864L;
	
	@Column(nullable = false, length = 50)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
