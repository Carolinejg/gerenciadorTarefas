package com.meuprojeto.gerenciarTarefa.dto;

import java.io.Serializable;

import com.meuprojeto.gerenciarTarefa.entities.Colaborador;

public class ColaboradorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private int idColaborador;
	private String nomeColaborador;
	
	public ColaboradorDTO() {
	}

	public ColaboradorDTO(int idColaborador, String nomeColaborador) {
		this.idColaborador = idColaborador;
		this.nomeColaborador = nomeColaborador;
	}
	
	public ColaboradorDTO(Colaborador entity) {
		this.idColaborador = entity.getIdColaborador();
		this.nomeColaborador = entity.getNomeColaborador();
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
	
	
	
}
