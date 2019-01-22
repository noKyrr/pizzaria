package uds.br.teste.pizzaria.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uds.br.teste.pizzaria.domain.Pedido;
import uds.br.teste.pizzaria.domain.Pizza;
import uds.br.teste.pizzaria.dto.MontarPizzaDto;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PedidoServiceTest {
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	PizzaService pizzaService;

	
	@Test
	@Transactional
	public void criarPedido() {
		try {
			
			Pizza pizza = montarPizzaComAdicionais();
			Pedido pedido = pedidoService.montarPedido(pizza.getId());
			
			assertEquals(pizza.getId(), pedido.getPizza().getId());
			assertEquals(Double.valueOf("23"),pedido.getTotal());
			assertEquals(15,pedido.getTotalTempoMinutos().intValue());
			
			pizza = pizzaService.acrescentaAdicional(pizza.getId(), 3l);
			assertEquals(pizza.getAdicionais().get(2).getId().longValue(), 3l);
			pedido = pedidoService.montarPedido(pizza.getId());
			
			assertEquals(pizza.getId(), pedido.getPizza().getId());
			assertEquals(Double.valueOf("28"),pedido.getTotal());
			assertEquals(20,pedido.getTotalTempoMinutos().intValue());
			
		}catch(Exception e) {
			fail();
		}
		
	}
	
	private Pizza montarPizzaComAdicionais() throws Exception {
		MontarPizzaDto dto = new MontarPizzaDto();
		dto.setSabor(1l);
		dto.setTamanho(1l);
		Pizza pizza = pizzaService.montarPizza(dto);
		assertNotNull(pizza);
		
		pizza = pizzaService.acrescentaAdicional(pizza.getId(), 1l);
		assertEquals(pizza.getAdicionais().get(0).getId().longValue(), 1l);

		pizza = pizzaService.acrescentaAdicional(pizza.getId(), 2l);
		assertEquals(pizza.getAdicionais().get(1).getId().longValue(), 2l);


		return pizza;
	}

	

	
}
