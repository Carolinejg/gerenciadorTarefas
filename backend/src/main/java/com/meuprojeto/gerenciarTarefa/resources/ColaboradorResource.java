package com.meuprojeto.gerenciarTarefa.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprojeto.gerenciarTarefa.entities.Colaborador;

//implementa o controlador REST gerando os recursos

@RestController
@RequestMapping(value = "/colaboradores")//a classe repsonde nessa rota
public class ColaboradorResource {
	//criando o endpoint
	//encapsula uma resposta HTTP
	
	@GetMapping
	public ResponseEntity<List<Colaborador>>findAll(){
		List<Colaborador>list = new ArrayList<>();
		list.add(new Colaborador(1,"carlos"));
		list.add(new Colaborador(2,"fernando"));
		return ResponseEntity.ok().body(list);//resposta 200 ou seja foi com sucesso
	}
	
}
