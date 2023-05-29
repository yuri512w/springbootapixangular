package br.com.organizacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.organizacao.entities.Produto;
import br.com.organizacao.repositories.IProdutoRepository;
import br.com.organizacao.request.ProdutoPostRequest;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class ProdutoController {
	
	@Autowired
	private IProdutoRepository produtoRepository;

	// endereco do serviço

	private static final String ENDPOINT = "/api/produto";

	// mérodo para realizar o cadastro

	@ApiOperation("Realizar o Cadastro")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<String> post(@RequestBody ProdutoPostRequest request) {
		try {
			Produto produto = new Produto();
			produto.setNome(request.getNome());
			produto.setDescricao(request.getDescricao());
			produtoRepository.save(produto);

			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Produto cadastrado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

}}
