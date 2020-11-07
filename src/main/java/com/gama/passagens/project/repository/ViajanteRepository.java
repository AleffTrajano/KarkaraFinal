package com.gama.passagens.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.gama.passagens.project.model.cadastro.Viajante;

public interface ViajanteRepository extends CrudRepository<Viajante, Integer> {
	boolean existsByEmail(String email);

	Viajante findFirstByEmail(String email);
}
