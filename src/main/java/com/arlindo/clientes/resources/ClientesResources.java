package com.arlindo.clientes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<List<Cliente>> listar() {								//Utiliza o ResponseEntity para fazer  retorno.
		
		return ResponseEntity.status(HttpStatus.OK).body(clientesRepository.findAll()); //Retorna ststus OK, e utiliza o body para fazer a busca no banco de dados
	} 
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Cliente cliente) {  //ResponseEntity para conseguir manipular a resposta.
		cliente = clientesRepository.save(cliente);
													
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()			//Pega a requisição corrente.
				.path("/{id}").buildAndExpand(cliente.getId()).toUri();		//adiciona no path que está chegando o id, e substitua o a uri a partir do recurso que foi salvo, e construa a URI.
		
		return ResponseEntity.created(uri).build(); 						//Traz a resposta Http com o status created e a uri na location, e faz o build.
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id) {
		Cliente cliente = clientesRepository.findById(id).orElse(null);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(cliente);	
		//Se o cliente existir, traz o statusCode .OK, e o corpo da requisição.
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar (@PathVariable int id) {
		if (clientesRepository.existsById(id)) {
			clientesRepository.deleteById(id);		
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build(); 
		}
	}  
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Cliente cliente, @PathVariable int id) {
		cliente.setId(id);
		clientesRepository.save(cliente);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
	
