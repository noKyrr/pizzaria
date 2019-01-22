package uds.br.teste.pizzaria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Tamanho;
import uds.br.teste.pizzaria.repositories.TamanhoRepository;

@Service
public class TamanhoService {

	@Autowired
	TamanhoRepository tamanhoRepository;

	public List<Tamanho> listarTamanhos() throws Exception {
		List<Tamanho> lista = tamanhoRepository.findAlltoList();
		if (lista == null || lista.isEmpty())
			throw new NotFoundException("Lista não encontrada");
		return lista;
	}
}
