package uds.br.teste.pizzaria.dto;

import java.io.Serializable;

public class MontarPizzaDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5975365966173303728L;
	private Long tamanho;
	private Long sabor;
	public Long getTamanho() {
		return tamanho;
	}
	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}
	public Long getSabor() {
		return sabor;
	}
	public void setSabor(Long sabor) {
		this.sabor = sabor;
	}
	
}
