package com.teste.hospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.hospede.entity.Cliente;

public interface ClienteRepostory  extends JpaRepository<Cliente, Long>{

}
