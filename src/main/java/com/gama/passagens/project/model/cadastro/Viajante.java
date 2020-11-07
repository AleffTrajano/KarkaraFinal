package com.gama.passagens.project.model.cadastro;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gama.passagens.project.model.acesso.Usuario;

@Entity
@Table(name = "tab_viajante")
public class Viajante extends Usuario {
	
	@Column(length = 60)
	private String nome;
	
	@Column(length = 15)
	private String cpfCnpj;
	
	@Column(length = 60)
	private String email;
	
	@Embedded
	private Telefone telefone;
	
	@Embedded
	private Documento documento;
	
	private LocalDate dataNascimento;
	
	private String sexo;
	
	@Embedded
	private Endereco endereco;
	
	
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	
	
}
