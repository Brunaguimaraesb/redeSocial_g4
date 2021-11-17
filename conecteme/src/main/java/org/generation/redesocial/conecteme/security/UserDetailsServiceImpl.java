package org.generation.redesocial.conecteme.security;

import java.util.Optional;

import org.generation.redesocial.conecteme.model.UsuarioModel;
import org.generation.redesocial.conecteme.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
		return user.map(UserDetailsImpl::new).get();
		
	}
}
