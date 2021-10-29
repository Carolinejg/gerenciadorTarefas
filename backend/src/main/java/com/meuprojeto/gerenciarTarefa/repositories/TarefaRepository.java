package com.meuprojeto.gerenciarTarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuprojeto.gerenciarTarefa.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
