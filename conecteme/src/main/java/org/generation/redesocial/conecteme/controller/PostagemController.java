package org.generation.redesocial.conecteme.controller;

import java.util.List;

import org.generation.redesocial.conecteme.model.PostagemModel;
import org.generation.redesocial.conecteme.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	

	@GetMapping("/{idPostagem}")
	public ResponseEntity<PostagemModel> GetById(@PathVariable long idPostagem){
		return repository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	
	

	@PostMapping
	public ResponseEntity<PostagemModel> post(@RequestBody PostagemModel titulo){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(titulo));
	}
	

	@PutMapping
	public ResponseEntity<PostagemModel> put(@RequestBody PostagemModel titulo){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(titulo));
	}

	

	@DeleteMapping("/{idPostagem}")
	public void delete(@PathVariable long idPostagem) {
		repository.deleteById(idPostagem);
	}

}

