package uds.br.teste.pizzaria.services;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TamanhoServiceTest {

	@Autowired
	TamanhoService tamanhoService;

	@Test
	@Transactional
	public void listarTamanhos() {
		try {
			assertTrue(tamanhoService.listarTamanhos().size() > 0);
		} catch (Exception e) {
			fail();
		}
	}
}
