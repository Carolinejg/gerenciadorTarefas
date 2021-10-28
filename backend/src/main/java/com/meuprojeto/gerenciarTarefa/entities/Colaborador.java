package com.meuprojeto.gerenciarTarefa.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//serializable permite o objeto ser passado na rede

@Entity
@Table(name="tb_colaborador")
public class Colaborador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//para ser auto incremento
	private int idColaborador;
	private String nomeColaborador;
		 
	public Colaborador() {
	
	}

	public Colaborador(int idColaborador, String nomeColaborador) {
		this.idColaborador = idColaborador;
		this.nomeColaborador = nomeColaborador;
	}

	public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idColaborador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return idColaborador == other.idColaborador;
	}
	
		 

}
