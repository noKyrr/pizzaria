package uds.br.teste.pizzaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Tamanho;
import uds.br.teste.pizzaria.services.TamanhoService;

@CrossOrigin(origins = "*")
@RestController
public class TamanhoController {

	@Autowired
	TamanhoService tamanhoService;

	@GetMapping(value = "/tamanhos", produces = "application/json")
	public ResponseEntity<List<Tamanho>> listarTamanhos() {
		try {
			return new ResponseEntity<>(tamanhoService.listarTamanhos(), HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
