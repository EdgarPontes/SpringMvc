package br.com.tecnonoticias.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String telefoneOne;
	private String telefoneTwo;
	private String telefoneThree;
	private String celular;
	private String whatsApp;
	private String email;
	private String facebook;
	private String instagram;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTelefoneOne() {
		return telefoneOne;
	}

	public void setTelefoneOne(String telefoneOne) {
		this.telefoneOne = telefoneOne;
	}

	public String getTelefoneTwo() {
		return telefoneTwo;
	}

	public void setTelefoneTwo(String telefoneTwo) {
		this.telefoneTwo = telefoneTwo;
	}

	public String getTelefoneThree() {
		return telefoneThree;
	}

	public void setTelefoneThree(String telefoneThree) {
		this.telefoneThree = telefoneThree;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
