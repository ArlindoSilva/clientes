package com.arlindo.clientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arlindo.clientes.domain.Cliente;
import com.arlindo.clientes.repository.ClientesRepository;

@RestController
public class ClientesResources {
	
	@Autowired
	private ClientesRepository clientesRepository;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		return clientesRepository.findAll();
	} 
}
