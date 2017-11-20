package com.ffb.construcao.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import com.ffb.construcao.util.Util;

public class ComparacoesHashMapTestes {

	Map<String, Object> implCaelum = new HashMapCaelum<String, Object>();

	Map<String, Object> implFFB = new MeuHashMap<String, Object>();

	Map<String, Object> implJava = new HashMap<String, Object>();

	@Test
	public void calculo_insercao_remocao_busca_para_mil_elementos_nos_3_algoritmos() {

		System.out.println("MIL ELEMENTOS \n");

		int quantidadeInsercoes = 1000;
		List<String> valoresDeBusca = new ArrayList<String>();
		List<String> valoresDeRemocao = new ArrayList<String>();
		Integer quantidadeExecucoes = 40;

		Random gerador = new Random();

		for (int i = 0; i < quantidadeExecucoes; i++) {

			valoresDeBusca.add(
					Integer.valueOf(gerador.nextInt(quantidadeInsercoes - 1))
							.toString());

			valoresDeRemocao.add(
					Integer.valueOf(gerador.nextInt(quantidadeInsercoes - 1))
							.toString());
		}

		System.out.println("TEMPO MÉDIO \n");

		System.out.println("CARREGANDO ALGORITMO DA CAELUM..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implCaelum));

		System.out.println("\n");

		System.out.println("CARREGANDO ALGORITMO DO TRABALHO..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implFFB));

		System.out.println("\n");

		System.out.println("CARREGANDO ALGORITMO DO JAVA..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implJava));

	}

	@Test
	public void calculo_insercao_remocao_busca_para_dez_mil_elementos_nos_3_algoritmos() {

		System.out.println("\n \n  DEZ MIL ELEMENTOS \n\n");

		int quantidadeInsercoes = 10000;
		List<String> valoresDeBusca = new ArrayList<String>();
		List<String> valoresDeRemocao = new ArrayList<String>();
		Integer quantidadeExecucoes = 10;

		Random gerador = new Random();

		for (int i = 0; i < quantidadeExecucoes; i++) {
			valoresDeBusca.add(Integer
					.valueOf(gerador.nextInt(quantidadeInsercoes)).toString());
			valoresDeRemocao.add(Integer
					.valueOf(gerador.nextInt(quantidadeInsercoes)).toString());
		}

		System.out.println("\n\n TEMPO MÉDIO \n\n");

		System.out.println("CARREGANDO ALGORITMO DA CAELUM..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implCaelum));

		System.out.println("\n");

		System.out.println("CARREGANDO ALGORITMO DO TRABALHO..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implFFB));

		System.out.println("CARREGANDO ALGORITMO DO JAVA..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implJava));
	}

	@Test
	public void calculo_insercao_remocao_busca_para_cem_mil_elementos_nos_3_algoritmos() {

		System.out.println("\n \n CEM MIL ELEMENTOS \n\n");

		int quantidadeInsercoes = 100000;
		List<String> valoresDeBusca = new ArrayList<String>();
		List<String> valoresDeRemocao = new ArrayList<String>();
		Integer quantidadeExecucoes = 10;

		Random gerador = new Random();

		for (int i = 0; i < quantidadeExecucoes; i++) {
			valoresDeBusca.add(Integer
					.valueOf(gerador.nextInt(quantidadeInsercoes)).toString());
			valoresDeRemocao.add(Integer
					.valueOf(gerador.nextInt(quantidadeInsercoes)).toString());
		}

		System.out.println("\n\n TEMPO MÉDIO \n\n");

		System.out.println("CARREGANDO ALGORITMO DA CAELUM..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implCaelum));

		System.out.println("\n");

		System.out.println("CARREGANDO ALGORITMO DO TRABALHO..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implFFB));

		System.out.println("CARREGANDO ALGORITMO DO JAVA..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implJava));
	}

	@Test
	public void calculo_insercao_remocao_busca_para_1_milhao_elementos_nos_3_algoritmos() {

		System.out.println("\n \n 1 MILHÃO ELEMENTOS \n\n");

		int quantidadeInsercoes = 1000000;
		List<String> valoresDeBusca = new ArrayList<String>();
		List<String> valoresDeRemocao = new ArrayList<String>();
		Integer quantidadeExecucoes = 3;

		Random gerador = new Random();

		for (int i = 0; i < quantidadeExecucoes; i++) {
			valoresDeBusca.add(Integer
					.valueOf(gerador.nextInt(quantidadeInsercoes)).toString());
			valoresDeRemocao.add(Integer
					.valueOf(gerador.nextInt(quantidadeInsercoes)).toString());
		}

		System.out.println("\n\n TEMPO MÉDIO \n\n");

		System.out.println("CARREGANDO ALGORITMO DA CAELUM..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implCaelum));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implCaelum));

		System.out.println("\n");

		System.out.println("CARREGANDO ALGORITMO DO TRABALHO..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implFFB));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implFFB));

		System.out.println("CARREGANDO ALGORITMO DO JAVA..");

		System.out.println(
				"Tempo Médio de inserção: " + Util.calcularMediaTempoInsercao(
						quantidadeInsercoes, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de busca: " + Util.calcularMediaTempoBusca(
						valoresDeBusca, quantidadeExecucoes, implJava));

		System.out.println(
				"Tempo Médio de remoção: " + Util.calcularMediaTempoRemocao(
						valoresDeRemocao, quantidadeExecucoes, implJava));

	}

}
