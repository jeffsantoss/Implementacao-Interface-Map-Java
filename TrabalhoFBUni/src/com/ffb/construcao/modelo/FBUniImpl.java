package com.ffb.construcao.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FBUniImpl<K, V> implements Map<K, V> {

	private List<List<Associacao<K, V>>> listaPrincipal = new ArrayList<List<Associacao<K, V>>>();

	private static final int VALOR_INCIAL = 1000000;

	public FBUniImpl() {
		for (int i = 0; i < VALOR_INCIAL; i++) {
			this.listaPrincipal.add(new ArrayList<Associacao<K, V>>());
		}
	}

	@Override
	public void clear() {
		listaPrincipal.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsKey(Object chave) {

		List<Associacao<K, V>> listaSecundaria = this
				.obterListaSecudariaPorChave((K) chave);

		if (listaSecundaria == null || listaSecundaria.size() == 0) {
			return false;
		} else if (buscaBinaria(listaSecundaria, (K) chave) == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean containsValue(Object valor) {

		for (List<Associacao<K, V>> list : listaPrincipal) {
			if (buscaBinaria(list, valor) != null) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object chave) {

		List<Associacao<K, V>> listaSecundaria = this
				.obterListaSecudariaPorChave((K) chave);

		@SuppressWarnings("unchecked")
		Associacao<K, V> associacaoEncontrada = buscaBinaria(listaSecundaria,
				(K) chave);

		if (associacaoEncontrada != null) {
			return associacaoEncontrada.getValor();
		}

		throw new IllegalArgumentException("A chave não existe");
	}

	@Override
	public boolean isEmpty() {
		return this.listaPrincipal.size() == 0;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	// considerar critério de ordenação pelo hashcode
	@Override
	public V put(K chave, V valor) {

		if (this.containsKey(chave)) {
			this.remove(chave);
		}

		List<Associacao<K, V>> listaSecundaria = obterListaSecudariaPorChave(
				(K) chave);

		Associacao<K, V> associacao = new Associacao<K, V>(chave, valor);

		listaSecundaria.add(associacao);

		// não tem sentindo ordenar a lista secundária que só contem um
		// elemento.
		if (listaSecundaria.size() > 1) {
			Collections.sort(listaSecundaria);
		}

		return associacao.getValor();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object chave) {

		List<Associacao<K, V>> listaSecundaria = this
				.obterListaSecudariaPorChave((K) chave);

		Associacao<K, V> associacaoEncontrada = buscaBinaria(listaSecundaria,
				(K) chave);

		if (associacaoEncontrada != null) {
			listaSecundaria.remove(associacaoEncontrada);
			return associacaoEncontrada.getValor();
		} else {
			throw new IllegalArgumentException("A chave não existe");
		}
	}

	@Override
	public int size() {

		Integer tamanhoTotal = 0;

		for (List<Associacao<K, V>> list : listaPrincipal) {
			tamanhoTotal += list.size();
		}

		return tamanhoTotal;
	}

	@Override
	public Collection<V> values() {

		Collection<V> valores = new ArrayList<V>();

		for (List<Associacao<K, V>> list : listaPrincipal) {
			for (Associacao<K, V> associacao : list) {
				valores.add(associacao.getValor());
			}
		}

		return valores;
	}

	/**
	 * Calculo do indice da lista principal baseado na chave passado como
	 * parâmetro.
	 * 
	 * @param chave
	 * @return indice da lista principal
	 */

	private int calcularHashCodeParaBuscarIndice(K chave) {
		return Math.abs(chave.hashCode()) % this.listaPrincipal.size();
	}

	/**
	 * @param chave
	 * @return lista secundária baseada no indíce calculado pela chave
	 */

	private List<Associacao<K, V>> obterListaSecudariaPorChave(K chave) {

		int indiceChave = this.calcularHashCodeParaBuscarIndice((K) chave);

		return this.listaPrincipal.get(indiceChave);
	}

	/**
	 * Retorna o valor de uma lista de associações, utilizando um algoritmo de
	 * busca binária.
	 * 
	 * @param lista
	 *            de associacoes ( ORDENADA )
	 * @return o valor da lista, caso não exista, retorna nulo.
	 */

	private Associacao<K, V> buscaBinaria(
			List<Associacao<K, V>> listaSecundaria, Object chaveValor) {

		Integer meio;
		Integer inicio = 0;
		Integer fim = listaSecundaria.size() - 1;

		while (inicio <= fim) {

			meio = (inicio + fim) / 2;

			Associacao<K, V> associacaoCorrente = listaSecundaria.get(meio);

			if (associacaoCorrente.getChave().equals(chaveValor)
					|| associacaoCorrente.getValor().equals(chaveValor))
				return associacaoCorrente;

			if (chaveValor.hashCode() < associacaoCorrente.getChave()
					.hashCode())
				fim = meio - 1;
			else
				inicio = meio + 1;

		}

		return null;
	}

}
