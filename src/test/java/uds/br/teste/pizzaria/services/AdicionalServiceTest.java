package uds.br.teste.pizzaria.services;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdicionalServiceTest {
	
	@Autowired
	AdicionalService adicionalService;

	@Test
	@Transactional
	public void listarAdicionais() {
		try {
			assertTrue(adicionalService.listarAdicionais().size() > 0);
		} catch (Exception e) {
			fail();
		}
	}

}
