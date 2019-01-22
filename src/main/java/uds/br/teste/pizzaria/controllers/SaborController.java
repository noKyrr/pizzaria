package uds.br.teste.pizzaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Sabor;
import uds.br.teste.pizzaria.services.SaborService;

@CrossOrigin(origins = "*")
@RestController
public class SaborController {
	
	@Autowired
	SaborService saborService;
	
	@GetMapping(value = "/sabores", produces = "application/json")
	public ResponseEntity<List<Sabor>> listarSabores() {
		try {
			return new ResponseEntity<>(saborService.listarSabores(), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
