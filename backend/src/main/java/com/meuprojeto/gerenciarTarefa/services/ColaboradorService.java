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

import com.meuprojeto.gerenciarTarefa.dto.ColaboradorDTO;
import com.meuprojeto.gerenciarTarefa.entities.Colaborador;
import com.meuprojeto.gerenciarTarefa.repositories.ColaboradorRepository;
import com.meuprojeto.gerenciarTarefa.services.exceptions.DatabaseException;
import com.meuprojeto.gerenciarTarefa.services.exceptions.ResourceNotFoundException;

//registra a classe como um componente que participa da injeção de dependencia

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;
	
	@Transactional(readOnly=true) //garantia da aplicação das propriedades ACIDE , readOnly nâo trava o banco 
	public List<ColaboradorDTO> findAll(){
		List<Colaborador> list= repository.findAll();
		List<ColaboradorDTO>listDto = new ArrayList<>();
		
		for(Colaborador cob : list) {
			listDto.add(new ColaboradorDTO(cob));
		}
		
		return listDto;
	}
	
	@Transactional(readOnly=true)
	public ColaboradorDTO findById(int id) {
		Optional<Colaborador>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Colaborador entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		
		return new ColaboradorDTO(entity);
	}
	@Transactional
	public ColaboradorDTO insert(ColaboradorDTO dto) {
		Colaborador entity = new Colaborador();
		entity.setNomeColaborador(dto.getNomeColaborador());
		entity = repository.save(entity);
		
		return new ColaboradorDTO(entity);

	}
	
	@Transactional
	public ColaboradorDTO update(int id,ColaboradorDTO dto) {
		try {
			Colaborador entity = repository.getOne(id);
			entity.setNomeColaborador(dto.getNomeColaborador());
			entity = repository.save(entity);
			
			return new ColaboradorDTO(entity);
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
