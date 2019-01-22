package uds.br.teste.pizzaria.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Adicional;
import uds.br.teste.pizzaria.domain.Pizza;
import uds.br.teste.pizzaria.domain.Sabor;
import uds.br.teste.pizzaria.domain.Tamanho;
import uds.br.teste.pizzaria.dto.MontarPizzaDto;
import uds.br.teste.pizzaria.repositories.AdicionalRepository;
import uds.br.teste.pizzaria.repositories.PizzaRepository;
import uds.br.teste.pizzaria.repositories.SaborRepository;
import uds.br.teste.pizzaria.repositories.TamanhoRepository;
import uds.br.teste.pizzaria.utils.exceptions.BusinessException;

@Service
public class PizzaService {
	
	@Autowired
	TamanhoRepository tamanhoRepository;
	@Autowired
	AdicionalRepository adicionalRepository;
	@Autowired
	SaborRepository saborRepository;
	@Autowired
	PizzaRepository pizzaRepository;
	
	public Pizza montarPizza(MontarPizzaDto pizzaDto) throws Exception {
		Tamanho tamanho = tamanhoRepository.findById(pizzaDto.getTamanho()).orElseThrow(() -> new NotFoundException("Tamanho não encontrado"));
		Sabor sabor = saborRepository.findById(pizzaDto.getSabor()).orElseThrow(() -> new NotFoundException("Sabor não encontrado"));
		
		return pizzaRepository.save(new Pizza(tamanho,sabor));
	}

	public Pizza acrescentaAdicional(Long idPizza, Long idAdicional) throws Exception {
		Pizza pizza = pizzaRepository.findById(idPizza).orElseThrow(() -> new NotFoundException("Pizza não encontrada"));
		Adicional adicional = adicionalRepository.findById(idAdicional).orElseThrow(() -> new NotFoundException("Adicional não encontrado"));
		
		if(pizza.getAdicionais() == null)
			pizza.setAdicionais(new ArrayList<>());
		else
			if(pizza.getAdicionais().contains(adicional))
				throw new BusinessException("Adicional já existente nessa pizza!");
		
		pizza.getAdicionais().add(adicional);
		return pizzaRepository.save(pizza);

	}

}
