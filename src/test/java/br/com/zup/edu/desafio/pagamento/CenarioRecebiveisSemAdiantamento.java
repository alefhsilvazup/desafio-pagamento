package br.com.zup.edu.desafio.pagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.zup.edu.desafio.pagamento.modifique.Solucao;

public class CenarioRecebiveisSemAdiantamento {

	@ParameterizedTest
	@MethodSource("geradorDeTransacoesSemAdiantamento")
	void teste(List<DadosTesteTransacao> infos,List<DadosEsperadosRetorno> retornosEsperados) throws Exception {
		ArrayList<String> paramsTransacoes = new ArrayList<>();
		for(DadosTesteTransacao info : infos) {			
			String param = String.format("%s,%s,%s,%s,%s,%s,%s", 
						info.valorTransacao,
						info.formaPagamento,
						"764387534", 
						"Nome do cartao", 
						LocalDate.now().plusYears(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						"457",
						info.idTransacao
						);
			System.out.println(param);
			paramsTransacoes.add(param);
			
		}
		
		List<String[]> retornos = Solucao.executa(paramsTransacoes,List.of());
		Assertions.assertEquals(retornosEsperados.size(), retornos.size());
		for(int i=0;i < retornos.size(); i++) {
			String status = retornos.get(i)[0];
			String valorOriginal = new BigDecimal(retornos.get(i)[1]).setScale(0,RoundingMode.HALF_EVEN).toString();
			String valorASerRecebido = new BigDecimal(retornos.get(i)[2]).setScale(0,RoundingMode.HALF_EVEN).toString();
			String data = retornos.get(i)[3];
			
			Assertions.assertEquals(retornosEsperados.get(i).status, status);
			Assertions.assertEquals(retornosEsperados.get(i).valorOriginal, valorOriginal);
			Assertions.assertEquals(retornosEsperados.get(i).valorASerRecebido, valorASerRecebido);
			Assertions.assertEquals(retornosEsperados.get(i).dataRecebimento, data);
		} 
	}

	static Stream<Arguments> geradorDeTransacoesSemAdiantamento() {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter padraoFormatacao = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");

		return Stream.of(
				Arguments.of(
						List.of(new DadosTesteTransacao("100", "DEBITO",1)),
						List.of(new DadosEsperadosRetorno("pago", "100", "97",
								hoje.format(padraoFormatacao))

						)),
				Arguments.of(
						List.of(new DadosTesteTransacao("100", "CREDITO",1)),
						List.of(new DadosEsperadosRetorno("aguardando_pagamento", "100", "95",
								hoje.plusDays(30).format(padraoFormatacao))

						)),
				Arguments.of(
						List.of(new DadosTesteTransacao("100", "CREDITO",1),
								new DadosTesteTransacao("100", "DEBITO",2)),
						List.of(new DadosEsperadosRetorno("aguardando_pagamento", "100", "95",hoje.plusDays(30).format(padraoFormatacao)),
								new DadosEsperadosRetorno("pago", "100", "97",hoje.format(padraoFormatacao))

						))				
				
				);

	}

} 
