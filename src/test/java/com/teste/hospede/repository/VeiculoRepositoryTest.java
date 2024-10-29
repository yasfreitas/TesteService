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

import com.teste.hospede.entity.Veiculo;

@DataJpaTest
class VeiculoRepositoryTest {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Veiculo veiculo1 = new Veiculo(null, "Nissan", "V3HW", 2021, "Preto");
		
		Veiculo saveVeiculo = veiculoRepository.save(veiculo1);
		
		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId()>0);
	}
	
	@DisplayName("Testando Get para todos os Hóspedes")
	@Test
	void testGetAllRepository() {
		
		Veiculo veiculo1 = new Veiculo(null, "Mercedes", "m3X", 2011, "Vinho");
		Veiculo veiculo2 = new Veiculo(null, "BMW", "N84D", 2024, "Preto");
		
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		
		List<Veiculo> veiculoList = veiculoRepository.findAll();
		
		assertNotNull(veiculoList);
		assertEquals(2, veiculoList.size());
		
	}
	
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		
		Veiculo veiculo1 = new Veiculo(null, "Fiat", "Fiesta", 2031, "Preto");
		
		veiculoRepository.save(veiculo1);
		
		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();
		
		assertNotNull(saveVeiculo);
		assertEquals(veiculo1.getId(), saveVeiculo.getId());
		
	}
	
	@DisplayName("Testando o UpDate")
	@Test
	void testUpdateVeiculo() {
		
		Veiculo veiculo1 = new Veiculo(null, "Ferrari", "V3HW", 2016, "Branco");
		
		veiculoRepository.save(veiculo1);
		
		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();
		veiculo1.setMarca("Fabiana");
		veiculo1.setModelo("2222222");
		
		Veiculo updateVeiculo = veiculoRepository.save(saveVeiculo);
		
		assertNotNull(updateVeiculo);
		assertEquals("Fabiana", updateVeiculo.getMarca());
		assertEquals("2222222", updateVeiculo.getModelo());
		
	}
	
	@DisplayName("Testando Delete")
	@Test
	void testDeleteVeiculo() {
		
		Veiculo veiculo1 = new Veiculo(null, "Hyundai", "NSW3KI", 2021, "Rosa");
		
		veiculoRepository.save(veiculo1);
		
		veiculoRepository.deleteById(veiculo1.getId());
		
		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(veiculo1.getId());
		
		assertTrue(veiculoOptional.isEmpty());
		
	}
	

}
