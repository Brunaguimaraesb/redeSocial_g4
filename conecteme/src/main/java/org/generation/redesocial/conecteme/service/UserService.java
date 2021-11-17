package org.generation.redesocial.conecteme.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.redesocial.conecteme.dtos.UserLoginDTO;
import org.generation.redesocial.conecteme.model.UsuarioModel;
import org.generation.redesocial.conecteme.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UsuarioRepository repository;

	public UsuarioModel CadastrarUsuario (UsuarioModel usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
				
	}
	
	public Optional<UserLoginDTO> Logar(Optional<UserLoginDTO> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
			
				user.get().setToken(authHeader);
				user.get().setEmail(usuario.get().getEmail());
				
				return user;
			}
		}
		
		return null;
	}
}
