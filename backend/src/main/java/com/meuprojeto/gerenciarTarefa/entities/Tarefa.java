package com.meuprojeto.gerenciarTarefa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_tarefa")
public class Tarefa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//para ser auto incremento
	public int id;
	@ManyToOne //muitas tarefas  ligam-se a um colaborador
	@JoinColumn(nullable = false)//campo obrigatorio
    public Colaborador colaborador;
    public String descrTarefa;
    public java.util.Date dataHoraInicio;
    public java.util.Date dataHoraFim;
    public String statusTarefa;
    public String prioridadeTarefa;
    
	public Tarefa() {
	}

	public Tarefa(int id, Colaborador colaborador, String descrTarefa, Date dataHoraInicio, Date dataHoraFim,
			String statusTarefa, String prioridadeTarefa) {
		this.id = id;
		this.colaborador = colaborador;
		this.descrTarefa = descrTarefa;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.statusTarefa = statusTarefa;
		this.prioridadeTarefa = prioridadeTarefa;
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
