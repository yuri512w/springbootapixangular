package br.com.organizacao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "historico")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idhistorico")
	private Integer idHistorico;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datahora", nullable = false)
	private Date dataHora;

	@Column(name = "operacao", length = 50, nullable = false)
	private String operacao;

	@ManyToOne
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;
}
