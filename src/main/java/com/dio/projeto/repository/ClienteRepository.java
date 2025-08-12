package com.dio.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import com.dio.projeto.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
