package uds.br.teste.pizzaria.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import uds.br.teste.pizzaria.domain.Pedido;
import uds.br.teste.pizzaria.domain.Pizza;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	
	Optional<Pedido> findOneByPizza(Pizza pizza);

}
