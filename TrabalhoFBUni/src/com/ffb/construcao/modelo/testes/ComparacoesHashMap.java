package com.ffb.construcao.modelo.testes;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ffb.construcao.modelo.CaelumImpl;
import com.ffb.construcao.modelo.FBUniImpl;
import com.ffb.construcao.util.Util;

public class ComparacoesHashMap {

	Map<String, Object> implCaelum = new CaelumImpl<String, Object>();

	Map<String, Object> implFFB = new FBUniImpl<String, Object>();

	Map<String, Object> implJava = new HashMap<String, Object>();

	private void printarTempoNormal(Integer quantidadeDeInsercoes) {

		System.out.println("[Tempo normal de execução com "
				+ quantidadeDeInsercoes + " elementos]");

		System.out.println("\n[Caelum]");

		System.out.println("Inserção: " + Util.calcularTempoInsercao(implCaelum,
				quantidadeDeInsercoes));

		System.out.println("Busca: " + Util.calcularTempoBuscaTodosElementos(
				implCaelum, quantidadeDeInsercoes));
		System.out
				.println("Remoção: " + Util.calcularTempoRemocaoTodosElementos(
						implCaelum, quantidadeDeInsercoes));

		System.out.println("\n[FBUni]: ");

		System.out.println("Inserção: "
				+ Util.calcularTempoInsercao(implFFB, quantidadeDeInsercoes));
		System.out.println("Busca: " + Util.calcularTempoBuscaTodosElementos(
				implFFB, quantidadeDeInsercoes));
		System.out.println(
				"Remoção: " + Util.calcularTempoRemocaoTodosElementos(implFFB,
						quantidadeDeInsercoes));

		System.out.println("\n[Java]: ");
		System.out.println("Inserção: "
				+ Util.calcularTempoInsercao(implJava, quantidadeDeInsercoes));
		System.out.println("Busca: " + Util.calcularTempoBuscaTodosElementos(
				implJava, quantidadeDeInsercoes));
		System.out.println(
				"Remoção: " + Util.calcularTempoRemocaoTodosElementos(implJava,
						quantidadeDeInsercoes));

	}

	private void printarTempoMedio(Integer quantidadeDeInsercoes,
			Integer quantidadeExecucoes) {

		System.out.println("[Tempo médio de execução com "
				+ quantidadeDeInsercoes + " elementos e " + quantidadeExecucoes
				+ " execuções]");

		// System.out.println("\n[Caelum]");
		// System.out.println("Inserção: " + Util.calcularMediaTempoInsercao(
		// quantidadeDeInsercoes, quantidadeExecucoes, implCaelum));
		// System.out.println("Busca: " +
		// Util.calcularMediaTempoBusca(implCaelum,
		// quantidadeExecucoes));
		// System.out.println("Remoção: " + Util
		// .calcularMediaTempoRemocao(quantidadeExecucoes, implCaelum));

		System.out.println("\n[FBUni]: ");
		System.out.println("Inserção: " + Util.calcularMediaTempoInsercao(
				quantidadeDeInsercoes, quantidadeExecucoes, implFFB));
		System.out.println("Busca: "
				+ Util.calcularMediaTempoBusca(implFFB, quantidadeExecucoes));
		System.out.println("Remoção: "
				+ Util.calcularMediaTempoRemocao(quantidadeExecucoes, implFFB));

		System.out.println("\n[Java]: ");
		System.out.println("Inserção: " + Util.calcularMediaTempoInsercao(
				quantidadeDeInsercoes, quantidadeExecucoes, implJava));
		System.out.println("Busca: "
				+ Util.calcularMediaTempoBusca(implJava, quantidadeExecucoes));
		System.out.println("Remoção: " + Util
				.calcularMediaTempoRemocao(quantidadeExecucoes, implJava));

	}

	@Test
	public void calculo_tempo_insercao_remocao_busca_nos_3_algoritmos() {
		printarTempoNormal(100000);
	}

	@Test
	public void calculo_tempo_medio_insercao_remocao_busca_nos_3_algoritmos() {
		printarTempoMedio(10000000, 3);
	}
}
