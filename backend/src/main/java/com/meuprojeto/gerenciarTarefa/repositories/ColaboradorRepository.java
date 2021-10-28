package com.meuprojeto.gerenciarTarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meuprojeto.gerenciarTarefa.entities.Colaborador;

@Repository //os objetos do tipo ColaboradorRepository passam a serem gerenciados pelo spring
public interface  ColaboradorRepository extends JpaRepository<Colaborador, Integer>{//por conta do id
	
}
