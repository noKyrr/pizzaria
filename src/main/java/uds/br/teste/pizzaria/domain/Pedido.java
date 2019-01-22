package uds.br.teste.pizzaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2180743842698186649L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Double total;
	@Column(nullable = false)
	private Integer totalTempoMinutos;

	@OneToOne(optional = false, mappedBy = "pedido", targetEntity = Pizza.class)
	private Pizza pizza;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getTotalTempoMinutos() {
		return totalTempoMinutos;
	}

	public void setTotalTempoMinutos(Integer totalTempoMinutos) {
		this.totalTempoMinutos = totalTempoMinutos;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public void somarTotalTempoMinutos(Integer acrescimo) {
		this.totalTempoMinutos += acrescimo;
	}

	public void somarTotalValorAdicional(Double acrescimo) {
		this.total += acrescimo;
		
	}
}
