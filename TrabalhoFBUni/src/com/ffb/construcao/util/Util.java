package com.ffb.construcao.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Util {

	public static float tempoEmSegundos(long start) {
		return ((float) (System.currentTimeMillis() - start) / 1000);
	}

	public static long tempoEmMS(long start) {
		return System.currentTimeMillis() - start;
	}

	private static void popularMap(Integer quantidadeDeInsercoes, Map<String, Object> implementacaoMap) {

		for (Integer i = 0; i < quantidadeDeInsercoes; i++) {
			implementacaoMap.put(i.toString(), i);
		}
	}

	/**
	 * calcula o tempo de inseção com base na implementação
	 * 
	 * @param quantidadeDeInsercoes
	 * @param implementacaoMap
	 * @return tempo
	 */

	public static float calcularTempoInsercao(Map<String, Object> implementacaoMap, Integer quantidadeDeInsercoes) {

		long start = System.currentTimeMillis();

		popularMap(quantidadeDeInsercoes, implementacaoMap);

		return tempoEmSegundos(start);
	}

	/**
	 * calcula o tempo de remoção com base na implementação
	 * 
	 * @param quantidadeDeInsercoes
	 * @param implementacaoMap
	 * @return tempo.
	 */

	public static float calcularTempoRemocaoTodosElementos(Map<String, Object> implementacaoMap, Integer qtdElementos) {

		long start = System.currentTimeMillis();

		for (Integer i = 0; i < qtdElementos; i++) {
			implementacaoMap.remove(i.toString());
		}

		return tempoEmSegundos(start);
	}

	/**
	 * calcula o tempo de busca com base na implementação
	 * 
	 * @param quantidadeDeInsercoes
	 * @param implementacaoMap
	 * @return tempo.
	 */

	public static float calcularTempoBusca(Map<String, Object> implementacaoMap, String chaveABuscar) {

		long start = System.currentTimeMillis();

		implementacaoMap.get(chaveABuscar);

		return tempoEmSegundos(start);
	}

	public static float calcularTempoBuscaTodosElementos(Map<String, Object> implementacaoMap, Integer qtdElementos) {

		long start = System.currentTimeMillis();

		for (Integer i = 0; i < qtdElementos; i++) {
			implementacaoMap.get(i.toString());
		}

		return tempoEmSegundos(start);
	}

	/**
	 * calcula o tempo MÉDIO de inserção com base na implementação
	 * 
	 * @param quantidadeDeInsercoes
	 *            e quantidade de execuçoes
	 * @param implementacaoMap
	 * @return tempo.
	 */

	public static long calcularMediaTempoInsercao(Integer quantidadeDeInsercoes, Integer quantidadeDeExecucoes,
			Map<String, Object> implementacaoMap) {

		List<Long> tempos = new ArrayList<Long>();

		for (int i = 0; i < quantidadeDeExecucoes; i++) {
			
			long start = System.currentTimeMillis();

			popularMap(quantidadeDeInsercoes, implementacaoMap);

			tempos.add(tempoEmMS(start));
		}

		long media = 0;

		for (long tempo : tempos) {
			media += tempo;
		}

		return media / tempos.size();
	}

	public static long calcularMediaTempoRemocao(Integer quantidadeDeExecucoes, Map<String, Object> implementacaoMap) {

		Integer qtdElementos = implementacaoMap.size();

		List<Long> tempos = new ArrayList<Long>();

		for (int i = 0; i < quantidadeDeExecucoes; i++) {

			long start = System.currentTimeMillis();

			for (Integer j = 0; j < qtdElementos; j++) {
				implementacaoMap.remove(j.toString());
			}

			tempos.add(tempoEmMS(start));

			popularMap(qtdElementos, implementacaoMap);
		}
		
		long media = 0;

		for (long tempo : tempos) {
			media += tempo;
		}

		return media / tempos.size();
	}

	public static long calcularMediaTempoBusca(Map<String, Object> implementacaoMap, Integer quantidadeDeExecucoes) {

		Integer qtdElementos = implementacaoMap.size();

		List<Long> tempos = new ArrayList<Long>();

		for (int i = 0; i < quantidadeDeExecucoes; i++) {

			long start = System.currentTimeMillis();

			for (Integer j = 0; j < qtdElementos; j++) {
				implementacaoMap.get(j.toString());
			}

			tempos.add(tempoEmMS(start));
		}

		long media = 0;

		for (long tempo : tempos) {
			media += tempo;
		}

		return media / tempos.size();
	}

}
