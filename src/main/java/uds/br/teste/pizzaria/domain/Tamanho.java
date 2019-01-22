package uds.br.teste.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

@Entity
public class Tamanho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4511269838708675932L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Double valor;
	@Column(nullable = false)
	private Integer preparoMinutos;
	@Column(nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getPreparoMinutos() {
		return preparoMinutos;
	}

	public void setPreparoMinutos(Integer preparoMinutos) {
		this.preparoMinutos = preparoMinutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
