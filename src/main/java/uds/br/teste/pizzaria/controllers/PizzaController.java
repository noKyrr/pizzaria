package uds.br.teste.pizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Pizza;
import uds.br.teste.pizzaria.dto.MontarPizzaDto;
import uds.br.teste.pizzaria.services.PizzaService;
import uds.br.teste.pizzaria.utils.exceptions.BusinessException;


@CrossOrigin(origins = "*")
@RestController
public class PizzaController {
	
	@Autowired
	PizzaService pizzaService;
	
	@PostMapping(value = "/pizza/montar", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> montarPizza(@RequestBody MontarPizzaDto pizzaDto) {
		try {
			return new ResponseEntity<Pizza>(pizzaService.montarPizza(pizzaDto),HttpStatus.CREATED);
		}catch(NotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ops, algo de errado aconteceu. Favor entrar em contato com a administração do sistema!.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/pizza/{idPizza}/adicional/{idAdicional}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> acrescentarAdicional(@PathVariable("idPizza") Long idPizza, @PathVariable("idAdicional") Long idAdicional) {
		try {
			return new ResponseEntity<Pizza>(pizzaService.acrescentaAdicional(idPizza,idAdicional),HttpStatus.OK);
		}catch(NotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(e.getMensagem(),HttpStatus.NOT_MODIFIED);
		}catch (Exception e) {
			return new ResponseEntity<String>("Ops, algo de errado aconteceu. Favor entrar em contato com a administração do sistema!.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
}
