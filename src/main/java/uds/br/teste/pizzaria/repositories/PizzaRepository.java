package uds.br.teste.pizzaria.repositories;

import org.springframework.data.repository.CrudRepository;

import uds.br.teste.pizzaria.domain.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

}
