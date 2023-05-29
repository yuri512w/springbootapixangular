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
	private String endereco;
	private String cep;
	private String numero;
	private String pasword;


}
