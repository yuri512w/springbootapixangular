package br.com.organizacao.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteGetResponse {
	
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;


}
