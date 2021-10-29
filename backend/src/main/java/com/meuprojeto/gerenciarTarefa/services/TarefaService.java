package com.meuprojeto.gerenciarTarefa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meuprojeto.gerenciarTarefa.dto.TarefaDTO;
import com.meuprojeto.gerenciarTarefa.entities.Tarefa;
import com.meuprojeto.gerenciarTarefa.repositories.TarefaRepository;
import com.meuprojeto.gerenciarTarefa.services.exceptions.DatabaseException;
import com.meuprojeto.gerenciarTarefa.services.exceptions.ResourceNotFoundException;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repository;
	
	@Transactional(readOnly=true) 
	public List<TarefaDTO> findAll() {
		List<Tarefa> list= repository.findAll();
		List<TarefaDTO>listDto = new ArrayList<>();
		
		for(Tarefa cob : list) {
			listDto.add(new TarefaDTO(cob));
		}
		
		return listDto;
		
	}

	@Transactional(readOnly=true)
	public TarefaDTO findById(int id) {
		Optional<Tarefa>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Tarefa entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new TarefaDTO(entity);
		
	}

	@Transactional
	public TarefaDTO insert(TarefaDTO dto) {
		Tarefa entity = new Tarefa();
		entity.setColaborador(dto.getColaborador());
		entity.setDescrTarefa(dto.getDescrTarefa());
		entity.setDataHoraInicio(dto.getDataHoraInicio());
		entity.setDataHoraFim(dto.getDataHoraFim());
		entity.setStatusTarefa(dto.getStatusTarefa());
		entity.setPrioridadeTarefa(dto.getPrioridadeTarefa());
		entity = repository.save(entity);
		
		return new TarefaDTO(entity);
		
	}

	@Transactional
	public TarefaDTO update(int id, TarefaDTO dto) {
		try {
			Tarefa entity = repository.getOne(id);
			entity.setColaborador(dto.getColaborador());
			entity.setDescrTarefa(dto.getDescrTarefa());
			entity.setDataHoraInicio(dto.getDataHoraInicio());
			entity.setDataHoraFim(dto.getDataHoraFim());
			entity.setStatusTarefa(dto.getStatusTarefa());
			entity.setPrioridadeTarefa(dto.getPrioridadeTarefa());
			entity = repository.save(entity);
			
			return new TarefaDTO(entity);
			
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id não encontrado "+id);
		}
	}

	public void delete(int id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado "+id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade do banco");
		}
		
	}

}
