package br.com.edu.blog.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "usuarios")
public class Usuario extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, name = "senha_hash")
	private String senha;
	
	@Column(nullable = false, name = "data_cadastro")
	private LocalDate dataCadastro;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Perfil perfil;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "avatar_id")
	private Avatar avatar;

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
}
