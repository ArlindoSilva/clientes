package com.arlindo.clientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arlindo.clientes.domain.Cliente;
import com.arlindo.clientes.repository.ClientesRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public Cliente buscar(@PathVariable int id) {
		return clientesRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable int id) {
		clientesRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Cliente cliente, @PathVariable int id) {
		cliente.setId(id);
		clientesRepository.save(cliente);
	}
	
}
	
