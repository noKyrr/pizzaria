package uds.br.teste.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Sabor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8154274381894712521L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = true)
	private Integer tempoAdicionalMinutos;
	@Column(nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTempoAdicionalMinutos() {
		return tempoAdicionalMinutos;
	}

	public void setTempoAdicionalMinutos(Integer tempoAdicionalMinutos) {
		this.tempoAdicionalMinutos = tempoAdicionalMinutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
