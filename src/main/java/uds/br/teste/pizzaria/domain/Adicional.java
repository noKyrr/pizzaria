package uds.br.teste.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adicional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -759359569806703064L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Double valorAdicional;
	@Column(nullable = false)
	private Integer TempoAdicionalMinutos;
	@Column(nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(Double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public Integer getTempoAdicionalMinutos() {
		return TempoAdicionalMinutos;
	}

	public void setTempoAdicionalMinutos(Integer tempoAdicionalMinutos) {
		TempoAdicionalMinutos = tempoAdicionalMinutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
