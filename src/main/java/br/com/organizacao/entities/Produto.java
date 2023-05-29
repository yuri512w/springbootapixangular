package br.com.organizacao.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduto")
	private Integer idproduto;
	@Column(name = "nome", length = 150, nullable = false)
	public String nome;
	@Column(name = "descricao", length = 150, nullable = false)
	public String descricao;
	
}
