package com.meuprojeto.gerenciarTarefa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meuprojeto.gerenciarTarefa.dto.TarefaDTO;
import com.meuprojeto.gerenciarTarefa.services.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {
	@Autowired //injetando
	private TarefaService service;
	
	@GetMapping
	public ResponseEntity<List<TarefaDTO>>findAll(){
		List<TarefaDTO>list = service.findAll();
		
		return ResponseEntity.ok().body(list);//resposta 200 ou seja foi com sucesso
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<TarefaDTO>findById(@PathVariable int id){
		TarefaDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);//resposta 200 ou seja foi com sucesso
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> insert(@RequestBody TarefaDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<TarefaDTO> update(@PathVariable int id,@RequestBody TarefaDTO dto){
		dto = service.update(id,dto);
		return ResponseEntity.ok().body(dto);
		
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}

}
