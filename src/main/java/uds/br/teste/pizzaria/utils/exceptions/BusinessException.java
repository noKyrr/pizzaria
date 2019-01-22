package uds.br.teste.pizzaria.utils.exceptions;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7612373992685460120L;

	private String mensagem;

	
	public BusinessException(String arg0) {
		super();
		this.mensagem = arg0;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	


	
	
}
