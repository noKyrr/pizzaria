package uds.br.teste.pizzaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import uds.br.teste.pizzaria.domain.Tamanho;

public interface TamanhoRepository extends CrudRepository<Tamanho, Long> {
	@Query(value="SELECT * FROM tamanho order by nome", nativeQuery = true)
	List<Tamanho> findAlltoList();
}
