package com.meuprojeto.gerenciarTarefa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuprojeto.gerenciarTarefa.entities.Colaborador;
import com.meuprojeto.gerenciarTarefa.repositories.ColaboradorRepository;

//registra a classe como um componente que participa da injeção de dependencia
@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	public List<Colaborador> findAll(){
		return repository.findAll();
	}

}
