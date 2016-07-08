package br.com.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "tb_convenio")
public class Convenio extends GenericModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5414112070589130056L;
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 10)
	private double valor;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

}
