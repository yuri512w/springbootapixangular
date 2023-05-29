package br.com.organizacao.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientePutRequest {
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String cep;
	private String numero;
	private String pasword;

}
