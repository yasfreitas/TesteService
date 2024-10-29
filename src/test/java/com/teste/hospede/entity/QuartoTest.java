package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {
	
	private Quarto quarto;

	@BeforeEach
	void setUp() {
		//Arrange
		quarto = new Quarto(1L, "6281", "casal");
	}

	@Test
	@DisplayName("Testando o Getter e Setter do campo ID")
	void testId() {
		//Act
		quarto.setId(2L);
		//Arrange
		assertEquals(2l, quarto.getId());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Num")
	void testNum() {
		//Act
		quarto.setNum("1234");
		//Arrange
		assertEquals("1234", quarto.getNum());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Tipo")
	void testTipo() {
		//Act
		quarto.setTipo("Suite master");
		//Arrange
		assertEquals("Suite master", quarto.getTipo());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Quarto novoQuarto = new Quarto(3L, "4321", "solteiro");
		//Assertion
		assertAll("novoQuarto", 
				()-> assertEquals(3L, novoQuarto.getId()), 
				()-> assertEquals("4321", novoQuarto.getNum()),
				()-> assertEquals("solteiro", novoQuarto.getTipo()));
	}
}
