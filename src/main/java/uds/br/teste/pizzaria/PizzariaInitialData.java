package uds.br.teste.pizzaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import uds.br.teste.pizzaria.domain.Adicional;
import uds.br.teste.pizzaria.domain.Sabor;
import uds.br.teste.pizzaria.domain.Tamanho;
import uds.br.teste.pizzaria.repositories.AdicionalRepository;
import uds.br.teste.pizzaria.repositories.SaborRepository;
import uds.br.teste.pizzaria.repositories.TamanhoRepository;

@Component
public class PizzariaInitialData {

	@Autowired
	AdicionalRepository adicionalRepository;
	
	@Autowired
	TamanhoRepository tamanhoRepository;
	
	@Autowired
	SaborRepository saborRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void onStartUp() {

		if(adicionalRepository.count() == 0) {
			Adicional adicional = new Adicional();
			adicional.setNome("Extra bacon");
			adicional.setValorAdicional(3d);
			adicional.setTempoAdicionalMinutos(0);
			adicionalRepository.save(adicional);

			adicional = new Adicional();
			adicional.setNome("Sem cebola");
			adicional.setValorAdicional(0d);
			adicional.setTempoAdicionalMinutos(0);
			adicionalRepository.save(adicional);

			adicional = new Adicional();
			adicional.setNome("Borda recheada");
			adicional.setValorAdicional(5d);
			adicional.setTempoAdicionalMinutos(5);
			adicionalRepository.save(adicional);
		}
		
		if(tamanhoRepository.count() == 0) {
			Tamanho tamanho = new Tamanho();
			tamanho.setNome("Pequena");
			tamanho.setValor(20d);
			tamanho.setPreparoMinutos(15);
			tamanhoRepository.save(tamanho);
			
			tamanho = new Tamanho();
			tamanho.setNome("Média");
			tamanho.setValor(30d);
			tamanho.setPreparoMinutos(20);
			tamanhoRepository.save(tamanho);
			
			tamanho = new Tamanho();
			tamanho.setNome("Grande");
			tamanho.setValor(40d);
			tamanho.setPreparoMinutos(25);
			tamanhoRepository.save(tamanho);
		}
		
		if(saborRepository.count() == 0) {
			Sabor sabor = new Sabor();
			sabor.setNome("Calabresa");
			sabor.setTempoAdicionalMinutos(0);
			saborRepository.save(sabor);
			
			sabor = new Sabor();
			sabor.setNome("Marguerita");
			sabor.setTempoAdicionalMinutos(0);
			saborRepository.save(sabor);
			
			sabor = new Sabor();
			sabor.setNome("Portuguesa");
			sabor.setTempoAdicionalMinutos(5);
			saborRepository.save(sabor);
		}
		

		
	}
}
