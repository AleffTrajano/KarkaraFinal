package com.gama.passagens.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.gama.passagens.project.model.acesso.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

	
}
