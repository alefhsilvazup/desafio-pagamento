package br.com.zup.edu.desafio.pagamento;

class DadosTesteTransacao {
	public final String valorTransacao;
	public final String formaPagamento;
	public final int idTransacao;

	public DadosTesteTransacao(String valorTransacao, String formaPagamento, int idTransacao) {
		super();
		this.valorTransacao = valorTransacao;
		this.formaPagamento = formaPagamento;
		this.idTransacao = idTransacao;
	}

	
	@Override
	public String toString() {
		return "DadosTesteTransacao [valorTransacao=" + valorTransacao
				+ ", formaPagamento=" + formaPagamento + ", idTransacao="
				+ idTransacao + "]";
	}

}