package br.com.organizacao.repositories;
import org.springframework.data.repository.CrudRepository;

import br.com.organizacao.entities.Produto;


public interface IProdutoRepository extends CrudRepository<Produto, Integer>{

}



