package org.generation.redesocial.conecteme.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class TemaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTema;
	
	@NotBlank
	@Size(min = 5, max = 100)
	private String tipo;
	
	@NotBlank
	@Size(min = 5, max = 500)
	private String descricao;
	
	@NotBlank
	private String foto;
	
	@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tipo")
	private List<PostagemModel> tb_postagens;
	
	public long getIdTema() {
		return idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}



}
