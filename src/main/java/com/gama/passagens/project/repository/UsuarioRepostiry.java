package com.gama.passagens.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.passagens.project.model.acesso.Usuario;

public interface UsuarioRepostiry extends JpaRepository<Usuario, Integer> {
	Usuario findByLogin(String login);
	boolean existsByLogin(String login);
}
