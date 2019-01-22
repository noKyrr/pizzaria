package uds.br.teste.pizzaria.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Pizza implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9134523709458835290L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private Tamanho tamanho;

	@ManyToOne(optional = false)
	private Sabor sabor;

	@OneToMany
	private List<Adicional> adicionais;

	@JsonIgnore
	@OneToOne(optional = true)
	private Pedido pedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public List<Adicional> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pizza() {
		super();
	}

	public Pizza(Tamanho tamanho, Sabor sabor) {
		super();
		this.tamanho = tamanho;
		this.sabor = sabor;
	}

	
}
