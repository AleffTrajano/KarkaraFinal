package com.gama.passagens.project.model.acesso;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Embeddable
//https://thorben-janssen.com/complete-guide-inheritance-strategies-jpa-hibernate/
//@Embeddable
//@MappedSuperclass

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tab_usuario")
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 70)
	private String login;
	
	@Column(length = 100)
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "login",nullable=false), inverseJoinColumns = @JoinColumn(name = "role",nullable=false))
	private Set<Role> roles = new HashSet<>();
	

	public Integer getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}
	public Set<Role> getRoles() {
		return roles;
	}
	
	
}
