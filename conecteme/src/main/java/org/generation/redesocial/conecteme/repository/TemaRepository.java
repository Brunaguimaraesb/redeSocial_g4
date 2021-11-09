package org.generation.redesocial.conecteme.repository;

import java.util.List;

import org.generation.redesocial.conecteme.model.TemaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {
	public List<TemaModel> findAllByTipoContainingIgnoreCase(String tipo);
}
