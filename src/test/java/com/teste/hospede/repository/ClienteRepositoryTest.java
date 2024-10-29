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

import com.teste.hospede.entity.Cliente;


@DataJpaTest
class ClienteRepositoryTest {

	@Autowired
	private ClienteRepostory clienteRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Cliente cliente1 = new Cliente(null, "Laura", "998192","1111111", "9191919191");
		
		Cliente saveCliente = clienteRepository.save(cliente1);
		
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId()>0);
	}
	
	@DisplayName("Testando Get para todos os Hóspedes")
	@Test
	void testGetAllRepository() {
		
		Cliente cliente1 = new Cliente(null, "Giovana", "99111111","8888888", "123456789");
		Cliente cliente2 = new Cliente(null, "Arielly", "8439238","122121212", "38392382");
		
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);
		
		List<Cliente> clienteList = clienteRepository.findAll();
		
		assertNotNull(clienteList);
		assertEquals(2, clienteList.size());
		
	}
	
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		
		Cliente cliente1 = new Cliente(null, "Mariana", "920123321","444444444", "728379321");
		
		clienteRepository.save(cliente1);
		
		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();
		
		assertNotNull(saveCliente);
		assertEquals(cliente1.getId(), saveCliente.getId());
		
	}
	
	@DisplayName("Testando o UpDate")
	@Test
	void testUpdateCliente() {
		
		Cliente cliente1 = new Cliente(null, "Laurindo", "998112","12342233", "81390213");
		
		clienteRepository.save(cliente1);
		
		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();
		cliente1.setNome("Fabiana");
		cliente1.setTelefone("2222222");
		cliente1.setCpf("1111111111");
		cliente1.setRg("333333333");
		
		Cliente updateCliente = clienteRepository.save(saveCliente);
		
		assertNotNull(updateCliente);
		assertEquals("Fabiana", updateCliente.getNome());
		assertEquals("2222222", updateCliente.getTelefone());
		assertEquals("1111111111", updateCliente.getCpf());
		assertEquals("333333333", updateCliente.getRg());
		
	}
	
	@DisplayName("Testando Delete")
	@Test
	void testDeleteCliente() {
		
		Cliente cliente1 = new Cliente(null, "Nilvado", "122222","221112","1212112");
		
		clienteRepository.save(cliente1);
		
		clienteRepository.deleteById(cliente1.getId());
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(cliente1.getId());
		
		assertTrue(clienteOptional.isEmpty());
		
	}

}
