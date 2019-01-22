package uds.br.teste.pizzaria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Pedido;
import uds.br.teste.pizzaria.domain.Pizza;
import uds.br.teste.pizzaria.repositories.PedidoRepository;
import uds.br.teste.pizzaria.repositories.PizzaRepository;

@Service
public class PedidoService {
	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	PedidoRepository pedidoRepository;

	public Pedido montarPedido(Long idPizza) throws Exception {
		if(idPizza == null)
			throw new  NotFoundException("Pizza não encontrada");
		Pizza pizza = pizzaRepository.findById(idPizza).orElseThrow(() -> new NotFoundException("Pizza não encontrada"));
		
		Optional<Pedido> pedidoExistente = pedidoRepository.findOneByPizza(pizza);
		if(pedidoExistente.isPresent())
			return atualizarPedido(pedidoExistente.get());
		
		Pedido novoPedido = criarPedido(pizza);
		return atualizarPedido(novoPedido);
	}

	private Pedido criarPedido(Pizza pizza) {
		Pedido retornoPedido = new Pedido();
		retornoPedido.setPizza(pizza);
		retornoPedido.setTotal(0d);
		retornoPedido.setTotalTempoMinutos(0);
		retornoPedido = pedidoRepository.save(retornoPedido);
		pizza.setPedido(retornoPedido);
		pizzaRepository.save(pizza);
		return retornoPedido;
	}

	private Pedido atualizarPedido(Pedido pedido) {
		pedido.setTotal(0d);
		pedido.setTotalTempoMinutos(0);
		
		atualizarDadosPizza(pedido);
		atualizarAdicionais(pedido);

		return pedidoRepository.save(pedido);
	}

	private void atualizarAdicionais(Pedido pedido) {
		pedido.getPizza().getAdicionais().forEach(adicional->{
			adicionarTempoTotal(pedido,adicional.getTempoAdicionalMinutos());
			adicionarValorTotal(pedido,adicional.getValorAdicional());
		});		

	}

	private void atualizarDadosPizza(Pedido pedido) {
		adicionarTempoTotal(pedido, pedido.getPizza().getTamanho().getPreparoMinutos());
		adicionarTempoTotal(pedido, pedido.getPizza().getSabor().getTempoAdicionalMinutos());
		adicionarValorTotal(pedido,pedido.getPizza().getTamanho().getValor());
	}

	private void adicionarTempoTotal(Pedido pedido, Integer integer) {
		if(integer != null)
			pedido.somarTotalTempoMinutos(integer);
	}

	private void adicionarValorTotal(Pedido pedido, Double valor) {
		if(valor != null)
			pedido.somarTotalValorAdicional(valor);
	}

}


