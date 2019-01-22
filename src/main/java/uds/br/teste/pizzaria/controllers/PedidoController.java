package uds.br.teste.pizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Pedido;
import uds.br.teste.pizzaria.domain.Pizza;
import uds.br.teste.pizzaria.services.PedidoService;

@CrossOrigin(origins = "*")
@RestController
public class PedidoController {

	@Autowired
	PedidoService pedidoService;
	
	@GetMapping(value = "/pedido/pizza/{idPizza}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> montarPedido(@PathVariable("idPizza") Long idPizza){
		try {
			return new ResponseEntity<Pedido>(pedidoService.montarPedido(idPizza),HttpStatus.OK);
		}catch(NotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ops, algo de errado aconteceu. Favor entrar em contato com a administração do sistema!.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
