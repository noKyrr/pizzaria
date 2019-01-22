package uds.br.teste.pizzaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Sabor;
import uds.br.teste.pizzaria.repositories.SaborRepository;

@Service
public class SaborService {

	@Autowired
	SaborRepository saborRepository;
	
	public List<Sabor> listarSabores() throws Exception {
		List<Sabor> lista = saborRepository.findAlltoList();
		if (lista == null || lista.isEmpty())
			throw new NotFoundException("Lista não encontrada");
		return lista;
	}
	
}
