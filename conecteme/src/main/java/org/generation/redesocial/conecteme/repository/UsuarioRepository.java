package org.generation.redesocial.conecteme.repository;

import java.util.List;
import java.util.Optional;

import org.generation.redesocial.conecteme.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);
	
	public Optional<UsuarioModel> findByEmail(String email); 

}
