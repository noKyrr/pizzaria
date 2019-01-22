package uds.br.teste.pizzaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uds.br.teste.pizzaria.domain.Adicional;
import uds.br.teste.pizzaria.repositories.AdicionalRepository;
import uds.br.teste.pizzaria.repositories.SaborRepository;
import uds.br.teste.pizzaria.repositories.TamanhoRepository;

@SpringBootApplication
public class PizzariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);

	}

}
