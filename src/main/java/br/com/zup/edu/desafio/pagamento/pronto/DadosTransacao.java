package br.com.zup.edu.desafio.pagamento.pronto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DadosTransacao {

	public final BigDecimal valor;
	public final MetodoPagamento metodo;
	public final String numero;
	public final String nome;
	public final LocalDate validade;
	public final int cvv;
	public final int id;

	public DadosTransacao(BigDecimal valor, MetodoPagamento metodo,
			String numero, String nome, LocalDate validade, int cvv, int id) {
				this.valor = valor;
				this.metodo = metodo;
				this.numero = numero;
				this.nome = nome;
				this.validade = validade;
				this.cvv = cvv;
				this.id = id;
	}

}
