package com.meuprojeto.gerenciarTarefa.dto;

import java.io.Serializable;
import java.util.Date;

import com.meuprojeto.gerenciarTarefa.entities.Colaborador;
import com.meuprojeto.gerenciarTarefa.entities.Tarefa;

public class TarefaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int id;
	public Colaborador colaborador;
    public String descrTarefa;
    public java.util.Date dataHoraInicio;
    public java.util.Date dataHoraFim;
    public String statusTarefa;
    public String prioridadeTarefa;
    
	public TarefaDTO() {
		
	}

	
	
	public TarefaDTO(int id, Colaborador colaborador, String descrTarefa, Date dataHoraInicio, Date dataHoraFim,
			String statusTarefa, String prioridadeTarefa) {
		this.id = id;
		this.colaborador = colaborador;
		this.descrTarefa = descrTarefa;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.statusTarefa = statusTarefa;
		this.prioridadeTarefa = prioridadeTarefa;
	}



	public TarefaDTO(Tarefa entity) {
		this.id = entity.getId();
		this.colaborador = entity.getColaborador();
		this.descrTarefa = entity.getDescrTarefa();
		this.dataHoraInicio = entity.getDataHoraInicio();
		this.dataHoraFim = entity.getDataHoraFim();
		this.statusTarefa = entity.getStatusTarefa();
		this.prioridadeTarefa = entity.getPrioridadeTarefa();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Colaborador getColaborador() {
		return colaborador;
	}



	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}



	public String getDescrTarefa() {
		return descrTarefa;
	}



	public void setDescrTarefa(String descrTarefa) {
		this.descrTarefa = descrTarefa;
	}



	public java.util.Date getDataHoraInicio() {
		return dataHoraInicio;
	}



	public void setDataHoraInicio(java.util.Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}



	public java.util.Date getDataHoraFim() {
		return dataHoraFim;
	}



	public void setDataHoraFim(java.util.Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}



	public String getStatusTarefa() {
		return statusTarefa;
	}



	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}



	public String getPrioridadeTarefa() {
		return prioridadeTarefa;
	}



	public void setPrioridadeTarefa(String prioridadeTarefa) {
		this.prioridadeTarefa = prioridadeTarefa;
	}


	
}
