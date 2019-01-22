package uds.br.teste.pizzaria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Adicional;
import uds.br.teste.pizzaria.repositories.AdicionalRepository;

@Service
public class AdicionalService {

	@Autowired
	AdicionalRepository adicionalRepositor;
	
	public List<Adicional> listarAdicionais() throws Exception {
		List<Adicional> lista = adicionalRepositor.findAlltoList();
		if (lista == null || lista.isEmpty())
			throw new NotFoundException("Lista não encontrada");
		return lista;
	}
	


}
