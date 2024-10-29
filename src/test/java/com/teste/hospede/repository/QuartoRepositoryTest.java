package com.teste.hospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.hospede.entity.Quarto;

@DataJpaTest
class QuartoRepositoryTest {

	@Autowired
	private QuartoRepository quartoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Quarto quarto1 = new Quarto(null, "8102", "Suíte master");
		
		Quarto saveQuarto = quartoRepository.save(quarto1);
		
		assertNotNull(saveQuarto);
		assertTrue(saveQuarto.getId()>0);
	}
	
	@DisplayName("Testando Get para todos os Quartos")
	@Test
	void testGetAllRepository() {
		
		Quarto quarto1 = new Quarto(null, "719", "solteiro");
		Quarto quarto2 = new Quarto(null, "192", "casal");
		
		quartoRepository.save(quarto1);
		quartoRepository.save(quarto2);
		
		List<Quarto> quartoList = quartoRepository.findAll();
		
		assertNotNull(quartoList);
		assertEquals(2, quartoList.size());
		
	}
	
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		
		Quarto quarto1 = new Quarto(null, "182", "3 camas");
		
		quartoRepository.save(quarto1);
		
		Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();
		
		assertNotNull(saveQuarto);
		assertEquals(quarto1.getId(), saveQuarto.getId());
		
	}
	
	@DisplayName("Testando o UpDate")
	@Test
	void testUpdateQuarto() {
		
		Quarto quarto1 = new Quarto(null, "9271", "suite normal");
		
		quartoRepository.save(quarto1);
		
		Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();
		quarto1.setNum("1111");
		quarto1.setTipo("suite master");
		
		Quarto updateQuarto = quartoRepository.save(saveQuarto);
		
		assertNotNull(updateQuarto);
		assertEquals("1111", updateQuarto.getNum());
		assertEquals("suite master", updateQuarto.getTipo());
		
	}
	
	@DisplayName("Testando Delete")
	@Test
	void testDeleteQuarto() {
		
		Quarto quarto1 = new Quarto(null, "222", "suite 4 camas");
		
		quartoRepository.save(quarto1);
		
		quartoRepository.deleteById(quarto1.getId());
		
		Optional<Quarto> quartoOptional = quartoRepository.findById(quarto1.getId());
		
		assertTrue(quartoOptional.isEmpty());
		
	}

}
