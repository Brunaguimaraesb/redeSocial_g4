package org.generation.redesocial.conecteme.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.generation.redesocial.conecteme.dtos.UserLoginDTO;
import org.generation.redesocial.conecteme.model.UsuarioModel;
import org.generation.redesocial.conecteme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/logar")
	public ResponseEntity<UserLoginDTO> Autentication(@Valid @RequestBody Optional<UserLoginDTO> user){
		return userService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	} 
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> Post(@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.CadastrarUsuario(usuario));
	}
}
