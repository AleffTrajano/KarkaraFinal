package com.gama.passagens.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.passagens.project.model.gestao.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Integer> {
	Operador findByLogin(String login);
	boolean existsByLogin(String login);
}
