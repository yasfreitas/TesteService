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

import com.teste.hospede.entity.Hospede;

@DataJpaTest
class HospedeRepositoryTest {

	@Autowired
	private HospedeRepository hospedeRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		
		Hospede saveHospede = hospedeRepository.save(hospede1);
		
		assertNotNull(saveHospede);
		assertTrue(saveHospede.getId()>0);
	}
	
	@DisplayName("Testando Get para todos os Hóspedes")
	@Test
	void testGetAllRepository() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		Hospede hospede2 = new Hospede(null, "Julio Mario", "julio@gmail.com", "(10)1010-1010");
		
		hospedeRepository.save(hospede1);
		hospedeRepository.save(hospede2);
		
		List<Hospede> hospedeList = hospedeRepository.findAll();
		
		assertNotNull(hospedeList);
		assertEquals(2, hospedeList.size());
		
	}
	
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		
		hospedeRepository.save(hospede1);
		
		Hospede saveHospede = hospedeRepository.findById(hospede1.getId()).get();
		
		assertNotNull(saveHospede);
		assertEquals(hospede1.getId(), saveHospede.getId());
		
	}
	
	@DisplayName("Testando o UpDate")
	@Test
	void testUpdateHospede() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		
		hospedeRepository.save(hospede1);
		
		Hospede saveHospede = hospedeRepository.findById(hospede1.getId()).get();
		hospede1.setName("Leonardo");
		hospede1.setEmail("leonardo@gmail.com");
		
		Hospede updateHospede = hospedeRepository.save(saveHospede);
		
		assertNotNull(updateHospede);
		assertEquals("Leonardo", updateHospede.getName());
		assertEquals("leonardo@gmail.com", updateHospede.getEmail());
		
	}
	
	@DisplayName("Testando Delete")
	@Test
	void testDeleteHospede() {
		
		Hospede hospede1 = new Hospede(null, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
		
		hospedeRepository.save(hospede1);
		
		hospedeRepository.deleteById(hospede1.getId());
		
		Optional<Hospede> hospedeOptional = hospedeRepository.findById(hospede1.getId());
		
		assertTrue(hospedeOptional.isEmpty());
		
	}
	

}
