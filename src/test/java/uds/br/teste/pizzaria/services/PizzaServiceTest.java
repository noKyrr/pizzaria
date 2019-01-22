package uds.br.teste.pizzaria.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javassist.NotFoundException;
import uds.br.teste.pizzaria.domain.Pizza;
import uds.br.teste.pizzaria.dto.MontarPizzaDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PizzaServiceTest {

	@Autowired
	PizzaService pizzaService;
	
	@Transactional
	@Test
	public void montarPizza() {
		MontarPizzaDto dto = new MontarPizzaDto();
		dto.setSabor(1l);
		dto.setTamanho(1l);
		
		try {
			Pizza pizza = pizzaService.montarPizza(dto);
			assertEquals(dto.getSabor(), pizza.getSabor().getId());
			assertEquals(dto.getTamanho(), pizza.getTamanho().getId());
			
			try{
				pizzaService.montarPizza(null);
				fail();
			}catch(Exception e) {
				assertNotNull(e);
			}
			
			try{
				dto.setSabor(0l);
				pizzaService.montarPizza(dto);
				fail();
			}catch(Exception e) {
				assertEquals(e.getMessage(), "Sabor não encontrado");
			}
			
			try{
				dto.setSabor(1l);
				dto.setTamanho(0l);
				pizzaService.montarPizza(dto);
				fail();
			}catch(Exception e) {
				assertEquals(e.getMessage(), "Tamanho não encontrado");
			}
			
		} catch (Exception e) {
			fail();
		}
		
	}
	
	@Transactional
	@Test
	public void acrescentaAdicional() {
		MontarPizzaDto dto = new MontarPizzaDto();
		dto.setSabor(1l);
		dto.setTamanho(1l);
		
		try {
			Pizza pizza = pizzaService.montarPizza(dto);
			assertNotNull(pizza);
			
			pizza = pizzaService.acrescentaAdicional(pizza.getId(), 1l);
			assertEquals(pizza.getAdicionais().get(0).getId().longValue(), 1l);
			try {
				pizzaService.acrescentaAdicional(pizza.getId(), 0l);
				fail();
			}catch(Exception e) {
				assertEquals(e.getClass(),NotFoundException.class);
			}		
		}catch (Exception e) {
			fail();
		}

		
	}
}
