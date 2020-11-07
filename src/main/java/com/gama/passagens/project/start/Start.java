package com.gama.passagens.project.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gama.passagens.project.model.acesso.Role;
import com.gama.passagens.project.model.gestao.Operador;
import com.gama.passagens.project.repository.OperadorRepository;
import com.gama.passagens.project.repository.RoleRepository;
import com.gama.passagens.project.service.CadastroService;

@Component
public class Start {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CadastroService service;
	
	public void init() {
		roles();
		operadorAdmin();
	}
	
	private void roles() {
		Role role = new Role("ADMIN");
		roleRepository.save(role);
		
		role = new Role("USER");
		roleRepository.save(role);
		
	}
	private void operadorAdmin() {
		
		Operador admin = new Operador();
		admin.setLogin("admin");
		admin.setNome("AMINISTRADOR");
		admin.addRole(new Role("ADMIN"));;
		admin.setSenha("admin");
		service.save(admin);
		
	}
	
}
