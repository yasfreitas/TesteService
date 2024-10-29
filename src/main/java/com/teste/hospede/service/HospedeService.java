package com.teste.hospede.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.hospede.entity.Hospede;
import com.teste.hospede.repository.HospedeRepository;

@Service
public class HospedeService {
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	public Hospede salvarHospede (Hospede hospede) {
		return hospedeRepository.save(hospede);
	}
	
	public List<Hospede> listarTodos(){
		return hospedeRepository.findAll();
	}
	
	public Optional <Hospede> buscarPorId(Long id){
		return hospedeRepository.findById(id);
	}
	
	public Hospede atualizarHospede(Hospede hospede) {
		if (hospedeRepository.existsById(hospede.getId())) {
			return hospedeRepository.save(hospede);
		} else {
			throw new RuntimeException("Hóspede não encontrado");
		}
	}
	
	public void deletarHospede(Long Id) {
		hospedeRepository.deleteById(Id);
	}

}
