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

import com.teste.hospede.entity.Produto;


@DataJpaTest
class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Produto produto1 = new Produto(null, "Sabonete", "$19.99");
		
		Produto saveProduto = produtoRepository.save(produto1);
		
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId()>0);
	}
	
	@DisplayName("Testando Get para todos os Hóspedes")
	@Test
	void testGetAllRepository() {
		
		Produto produto1 = new Produto(null, "Livro", "$79.99");
		Produto produto2 = new Produto(null, "Máscara Capilar", "$1.99");
		
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		
		List<Produto> produtoList = produtoRepository.findAll();
		
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());
		
	}
	
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		
		Produto produto1 = new Produto(null, "Sabão em pó", "$11.99");
		
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		
		assertNotNull(saveProduto);
		assertEquals(produto1.getId(), saveProduto.getId());
		
	}
	
	@DisplayName("Testando o UpDate")
	@Test
	void testUpdateProduto() {
		
		Produto produto1 = new Produto(null, "Fita isolante", "$3.99");
		
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("Fita Crepe");
		produto1.setPreco("$2.99");
		
		Produto updateProduto = produtoRepository.save(saveProduto);
		
		assertNotNull(updateProduto);
		assertEquals("Fita Crepe", updateProduto.getNome());
		assertEquals("$2.99", updateProduto.getPreco());
		
	}
	
	@DisplayName("Testando Delete")
	@Test
	void testDeleteProduto() {
		
		Produto produto1 = new Produto(null, "Óculos", "$59.99");
		
		produtoRepository.save(produto1);
		
		produtoRepository.deleteById(produto1.getId());
		
		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());
		
		assertTrue(produtoOptional.isEmpty());
		
	}

}
