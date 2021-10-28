package com.meuprojeto.gerenciarTarefa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprojeto.gerenciarTarefa.dto.ColaboradorDTO;
import com.meuprojeto.gerenciarTarefa.services.ColaboradorService;

//implementa o controlador REST gerando os recursos

@RestController
@RequestMapping(value = "/colaboradores")//a classe repsonde nessa rota
public class ColaboradorResource {
	//criando o endpoint
	//encapsula uma resposta HTTP
	
	@Autowired //injetando
	private ColaboradorService service;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>>findAll(){
		List<ColaboradorDTO>list = service.findAll();
		
		return ResponseEntity.ok().body(list);//resposta 200 ou seja foi com sucesso
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ColaboradorDTO>findById(@PathVariable int id){
		ColaboradorDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);//resposta 200 ou seja foi com sucesso
	}
	
	
}
