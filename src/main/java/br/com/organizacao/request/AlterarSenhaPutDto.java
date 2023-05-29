package br.com.organizacao.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlterarSenhaPutDto {

	private String senhaAtual;
	private String novaSenha;

}
