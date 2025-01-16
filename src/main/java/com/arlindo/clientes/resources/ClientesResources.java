package com.arlindo.clientes.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arlindo.clientes.domain.Cliente;

@RestController
public class ClientesResources {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		Cliente c1 = new Cliente("Ana");
		Cliente c2 = new Cliente("João");
		
		Cliente[] clientela = {c1, c2};
		
		return Arrays.asList(clientela);
	}
}
