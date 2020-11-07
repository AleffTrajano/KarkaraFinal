package com.gama.passagens.project.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gama.passagens.project.model.acesso.Role;
import com.gama.passagens.project.model.acesso.Usuario;
import com.gama.passagens.project.model.cadastro.Viajante;
import com.gama.passagens.project.model.gestao.Operador;
import com.gama.passagens.project.repository.UsuarioRepostiry;
import com.gama.passagens.project.repository.ViajanteRepository;

@Service
public class CadastroService {
	
	@Autowired
	private ViajanteRepository repository;
		
	@Autowired
	private UsuarioRepostiry userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	private Integer saveUsuario(Usuario usuario) {
	
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		if(!userRepository.existsByLogin(usuario.getLogin())) {
			usuario = userRepository.save(usuario);
			return usuario.getId();
		}
		return null;
	}
	public Integer save(Operador operador) {
		return saveUsuario(operador);
	}
	
	public Integer save(Viajante cliente) {
		if(cliente.getId()==null) {
			cliente.setRoles(new HashSet<>());
			cliente.addRole(new Role("USER"));
		}
		 return saveUsuario(cliente);
		
	}
	
	
}
