package br.com.zup.edu.desafio.pagamento.pronto;

import java.math.BigDecimal;

public class DadosRecebimentoAdiantado {

	public final int idTransacao;
	public final BigDecimal taxa;

	public DadosRecebimentoAdiantado(int idTransacao, BigDecimal taxa) {
		this.idTransacao = idTransacao;
		this.taxa = taxa;
	}

	@Override
	public String toString() {
		return "DadosRecebimentoAdiantado [idTransacao=" + idTransacao
				+ ", taxa=" + taxa + "]";
	}
	
	

}
