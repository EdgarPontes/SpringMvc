package br.com.tecnonoticias.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "cadastro_admin")
public class CadastroAdmin {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(nullable = false, length = 25)
	@NotBlank(message = "Usuário é Obrigatório.")
	private String usuario;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Email é Obrigatório")
	private String email;
	
	@Column(nullable = false, length = 25)
	@NotBlank(message = "Senha não Informada.")
	private String senha;
	
	@Column(nullable = false, length = 25)
	@NotBlank(message = "Senha não Informada.")
	private String permissao;
	
	@Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Data é uma informação obrigatória.")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date data;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	 
	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
