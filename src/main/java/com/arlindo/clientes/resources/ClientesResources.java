package com.arlindo.clientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arlindo.clientes.domain.Cliente;
import com.arlindo.clientes.repository.ClientesRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/clientes")
public class ClientesResources {
	
	@Autowired
	private ClientesRepository clientesRepository;

	@GetMapping
	public List<Cliente> listar() {
		
		return clientesRepository.findAll(); 
	} 
	
	@PostMapping
	public void salvar(@RequestBody Cliente cliente) {  
		
	  clientesRepository.save(cliente);
	}
}
	
