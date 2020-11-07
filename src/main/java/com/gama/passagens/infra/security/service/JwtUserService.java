package com.gama.passagens.infra.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gama.passagens.project.model.acesso.Usuario;
import com.gama.passagens.project.model.cadastro.Viajante;
import com.gama.passagens.project.repository.ViajanteRepository;
import com.gama.passagens.project.repository.UsuarioRepostiry;

@Service(value = "jwtUserService")
public class JwtUserService implements UserDetailsService  {
	@Autowired
	private UsuarioRepostiry repository;
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = repository.findByLogin(login);
		if(usuario == null){
			throw new UsernameNotFoundException("Usuário não existe");
		}
		Set<SimpleGrantedAuthority> roles=getAuthority(usuario);
		return new org.springframework.security.core.userdetails.User(usuario.getLogin(), usuario.getSenha(), roles);
	}
	private Set<SimpleGrantedAuthority> getAuthority(Usuario user){
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getNome().toUpperCase()));
		});
		return authorities;
	}
}
