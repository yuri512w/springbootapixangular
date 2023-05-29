package br.com.organizacao.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.organizacao.entities.Cliente;


public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

}
