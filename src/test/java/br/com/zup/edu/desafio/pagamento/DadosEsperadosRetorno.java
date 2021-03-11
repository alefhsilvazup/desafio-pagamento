package br.com.zup.edu.desafio.pagamento;

class DadosEsperadosRetorno {
	public final String status;
	public final String valorOriginal;
	public final String valorASerRecebido;
	public final String dataRecebimento;

	public DadosEsperadosRetorno(String status, String valorOriginal,
			String valorASerRecebido, String dataRecebimento) {
		super();
		this.status = status;
		this.valorOriginal = valorOriginal;
		this.valorASerRecebido = valorASerRecebido;
		this.dataRecebimento = dataRecebimento;
	}

	@Override
	public String toString() {
		return "DadosEsperadosRetorno [status=" + status + ", valorOriginal="
				+ valorOriginal + ", valorASerRecebido=" + valorASerRecebido
				+ ", dataRecebimento=" + dataRecebimento + "]";
	}

}