package uds.br.teste.pizzaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import uds.br.teste.pizzaria.domain.Sabor;
import uds.br.teste.pizzaria.domain.Tamanho;

public interface SaborRepository extends CrudRepository<Sabor, Long> {
	@Query(value="SELECT * FROM sabor order by nome", nativeQuery = true)
	List<Sabor> findAlltoList();
}
