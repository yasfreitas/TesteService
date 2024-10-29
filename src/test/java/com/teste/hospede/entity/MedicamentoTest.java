package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MedicamentoTest {
	
	private Medicamento medicamento;
	
	@BeforeEach
	void setUp() {
		//Arrange
		medicamento = new Medicamento(1L, "Clonazepam", "Prescrição Médica", "25/11/2035");
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo ID")
	void testId() {
		//Act
		medicamento.setId(2L);
		//Arrange
		assertEquals(2l, medicamento.getId());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Nome")
	void testNome() {
		//Act
		medicamento.setName("Rivotril");
		//Arrange
		assertEquals("Rivotril", medicamento.getName());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Bula")
	void testBula() {
		//Act
		medicamento.setBula("Prescrição Médica");
		//Arrange
		assertEquals("Prescrição Médica", medicamento.getBula());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo dataValidade")
	void testDataValidade() {
		//Act
		medicamento.setDataValidade("21/01/2040");
		//Arrange
		assertEquals("21/01/2040", medicamento.getDataValidade());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Medicamento novoMedicamento = new Medicamento(3L, "Tradozona", "Prescrição Médica", "01/12/2035");
		//Assertion
		assertAll("novoHospede", 
				()-> assertEquals(3L, novoMedicamento.getId()), 
				()-> assertEquals("Tradozona", novoMedicamento.getName()),
				()-> assertEquals("Prescrição Médica", novoMedicamento.getBula()),
				()-> assertEquals("01/12/2035", novoMedicamento.getDataValidade()));
	}
	

}
