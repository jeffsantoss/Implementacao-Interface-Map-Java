package com.ffb.construcao.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Util {

	private static void popularMap(Integer quantidadeDeInsercoes,
			Map<String, Object> implementacaoMap) {

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

	public static Long calcularTempoInsercao(Integer quantidadeDeInsercoes,
			Map<String, Object> implementacaoMap) {

		long start = System.currentTimeMillis();

		popularMap(quantidadeDeInsercoes, implementacaoMap);

		return System.currentTimeMillis() - start;
	}

	/**
	 * calcula o tempo de remoção com base na implementação
	 * 
	 * @param quantidadeDeInsercoes
	 * @param implementacaoMap
	 * @return tempo.
	 */

	public static long calcularTempoRemocao(
			Map<String, Object> implementacaoMap, String chaveARemover) {

		long start = System.currentTimeMillis();

		implementacaoMap.remove(chaveARemover);

		return System.currentTimeMillis() - start;
	}

	/**
	 * calcula o tempo de busca com base na implementação
	 * 
	 * @param quantidadeDeInsercoes
	 * @param implementacaoMap
	 * @return tempo.
	 */

	public static long calcularTempoBusca(Map<String, Object> implementacaoMap,
			String chaveABuscar) {

		long start = System.currentTimeMillis();

		implementacaoMap.get(chaveABuscar);

		return System.currentTimeMillis() - start;
	}

	/**
	 * calcula o tempo MÉDIO de inserção com base na implementação
	 * 
	 * @param quantidadeDeInsercoes
	 *            e quantidade de execuçoes
	 * @param implementacaoMap
	 * @return tempo.
	 */

	public static Double calcularMediaTempoInsercao(
			Integer quantidadeDeInsercoes, Integer quantidadeDeExecucoes,
			Map<String, Object> implementacaoMap) {

		List<Long> tempos = new ArrayList<Long>();

		for (int i = 0; i < quantidadeDeExecucoes; i++) {
			tempos.add(Util.calcularTempoInsercao(quantidadeDeInsercoes,
					implementacaoMap));
		}

		Double media = 0d;

		for (Long tempo : tempos) {
			media += tempo;
		}

		return media / tempos.size();
	}

	public static Double calcularMediaTempoRemocao(List<String> valores,
			Integer quantidadeDeExecucoes,
			Map<String, Object> implementacaoMap) {

		List<Long> tempos = new ArrayList<Long>();

		for (int i = 0; i < quantidadeDeExecucoes; i++) {
			tempos.add(Util.calcularTempoRemocao(implementacaoMap,
					valores.get(i)));
		}

		Double media = 0d;

		for (Long tempo : tempos) {
			media += tempo;
		}

		return media / tempos.size();
	}

	public static Double calcularMediaTempoBusca(List<String> valores,
			Integer quantidadeDeExecucoes,
			Map<String, Object> implementacaoMap) {

		List<Long> tempos = new ArrayList<Long>();

		for (int i = 0; i < quantidadeDeExecucoes; i++) {
			tempos.add(
					Util.calcularTempoBusca(implementacaoMap, valores.get(i)));
		}

		Double media = 0d;

		for (Long tempo : tempos) {
			media += tempo;
		}

		return media / tempos.size();
	}

}
