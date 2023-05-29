package br.com.organizacao.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CriarContaPostDto {

	private String nome;
	private String email;
	private String senha;
	
}
