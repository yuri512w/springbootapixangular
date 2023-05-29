package br.com.organizacao.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.organizacao.dtos.AutenticarPostDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Autenticação de usuários")
@RestController
public class AutenticarController {

	@ApiOperation("Serviço para autenticação de usuários e geração de TOKEN JWT.")
	@PostMapping("api/autenticar")
	public void post(@RequestBody AutenticarPostDto dto) {
		// TODO
	}

}
