package br.com.tecnonoticias.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "banner")
public class Banner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String bannerUm;
	private String descricaoUm;
	private String bannerDois;
	private String descricaoDois;
	private String bannerTres;
	private String descricaoTres;
	private String bannerQuatro;
	private String descricaoQuatro;
	private String bannerCinco;
	private String descricaoCinco;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getBannerUm() {
		return bannerUm;
	}
	public void setBannerUm(String bannerUm) {
		this.bannerUm = bannerUm;
	}
	public String getDescricaoUm() {
		return descricaoUm;
	}
	public void setDescricaoUm(String descricaoUm) {
		this.descricaoUm = descricaoUm;
	}
	public String getBannerDois() {
		return bannerDois;
	}
	public void setBannerDois(String bannerDois) {
		this.bannerDois = bannerDois;
	}
	public String getDescricaoDois() {
		return descricaoDois;
	}
	public void setDescricaoDois(String descricaoDois) {
		this.descricaoDois = descricaoDois;
	}
	public String getBannerTres() {
		return bannerTres;
	}
	public void setBannerTres(String bannerTres) {
		this.bannerTres = bannerTres;
	}
	public String getDescricaoTres() {
		return descricaoTres;
	}
	public void setDescricaoTres(String descricaoTres) {
		this.descricaoTres = descricaoTres;
	}
	public String getBannerQuatro() {
		return bannerQuatro;
	}
	public void setBannerQuatro(String bannerQuatro) {
		this.bannerQuatro = bannerQuatro;
	}
	public String getDescricaoQuatro() {
		return descricaoQuatro;
	}
	public void setDescricaoQuatro(String descricaoQuatro) {
		this.descricaoQuatro = descricaoQuatro;
	}
	public String getBannerCinco() {
		return bannerCinco;
	}
	public void setBannerCinco(String bannerCinco) {
		this.bannerCinco = bannerCinco;
	}
	public String getDescricaoCinco() {
		return descricaoCinco;
	}
	public void setDescricaoCinco(String descricaoCinco) {
		this.descricaoCinco = descricaoCinco;
	}
}
