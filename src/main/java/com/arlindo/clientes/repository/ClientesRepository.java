package com.arlindo.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arlindo.clientes.domain.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer>{

}
