package com.teste.hospede.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.hospede.entity.Hospede;
import com.teste.hospede.repository.HospedeRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class HospedeServiceTest {

	@Autowired
	private HospedeService hospedeService;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@BeforeEach
	void setUp() {
		hospedeRepository.deleteAll();
	}
	
	@DisplayName("Testando salvar hospede")
	@Test
	void testSalvarHospede() {
		Hospede hospede = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)00000-0000");
		
		Hospede resultado = hospedeService.salvarHospede(hospede);
		
		assertNotNull(resultado);
		assertEquals("Julia Maria", resultado.getName());
		assertTrue(resultado.getId()>0);
	}
	
	@DisplayName("Testando listar todos os hospedes")
	@Test
	void testListarTodos() {
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)00000-0000");
		Hospede hospede2 = new Hospede(null, "Julio Mario", "juli0@gmail.com", "(10)00100-0001");
		
		hospedeService.salvarHospede(hospede1);
		hospedeService.salvarHospede(hospede2);
		
		List<Hospede> resultado = hospedeService.listarTodos();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}
	
	@DisplayName("Testando buscar hospede por ID")
	@Test
	void testBuscarPorId() {
		Hospede hospede = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)00000-0000");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isPresent());
		assertEquals("Julia Maria", resultado.get().getName());
	}
	
	@DisplayName("Testando atualizar hospede")
	@Test
	void testAtualizarHospede() {
		Hospede hospede = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		
		salvo.setName("Leonardo");
		salvo.setEmail("leonardo@gmail.com");
		
		Hospede atualizado = hospedeService.atualizarHospede(salvo);
		
		assertNotNull(atualizado);
		assertEquals("Leonardo", atualizado.getName());
		assertEquals("leonardo@gmail.com", atualizado.getEmail());
	}
	
	@DisplayName("Testando Deletar Hospedes")
	@Test
	void testDeletarHospede() {
		Hospede hospede = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		
		Hospede salvo = hospedeService.salvarHospede(hospede);
		hospedeService.deletarHospede(salvo.getId());
		
		Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isEmpty());
	}

}
