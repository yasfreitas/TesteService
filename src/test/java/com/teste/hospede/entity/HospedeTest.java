package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {
	
	private Hospede hospede;
	
	@BeforeEach
	void setUp() {
		//Arrange
		hospede = new Hospede(1L, "Cristiane Santos", "crissantos@outlook.com", "(11)9 9238-8192");
	}

	@Test
	@DisplayName("Testando o Getter e Setter do campo ID")
	void testId() {
		//Act
		hospede.setId(2L);
		//Arrange
		assertEquals(2l, hospede.getId());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Nome")
	void testNome() {
		//Act
		hospede.setName("Luana Vitória");
		//Arrange
		assertEquals("Luana Vitória", hospede.getName());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Email")
	void testEmail() {
		//Act
		hospede.setEmail("marimaria@hotmail.com");
		//Arrange
		assertEquals("marimaria@hotmail.com", hospede.getEmail());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Telefone")
	void testTelefone() {
		//Act
		hospede.setTelefone("(11)9 7292-9183");
		//Arrange
		assertEquals("(11)9 7292-9183", hospede.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Hospede novoHospede = new Hospede(3L, "Clarita Neves", "claraneves@gmail.com", "(11)9 9173-9183");
		//Assertion
		assertAll("novoHospede", 
				()-> assertEquals(3L, novoHospede.getId()), 
				()-> assertEquals("Clarita Neves", novoHospede.getName()),
				()-> assertEquals("claraneves@gmail.com", novoHospede.getEmail()),
				()-> assertEquals("(11)9 9173-9183", novoHospede.getTelefone()));
	}
	

}
