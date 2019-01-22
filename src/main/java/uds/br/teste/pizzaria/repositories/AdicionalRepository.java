package uds.br.teste.pizzaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import uds.br.teste.pizzaria.domain.Adicional;

public interface AdicionalRepository extends CrudRepository<Adicional, Long> {
	
	@Query(value="SELECT * FROM adicional order by nome", nativeQuery = true)
	List<Adicional> findAlltoList();

}
