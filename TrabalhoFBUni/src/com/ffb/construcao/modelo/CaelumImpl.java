package com.ffb.construcao.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CaelumImpl<K, V> implements Map<K, V> {

	private List<List<Associacao<K, V>>> tabela = new ArrayList<List<Associacao<K, V>>>();

	public CaelumImpl() {
		for (int i = 0; i < 100; i++) {
			this.tabela.add(new LinkedList<Associacao<K, V>>());
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsKey(Object placa) {

		int indice = this.calculaIndiceDaTabela((K) placa);

		List<Associacao<K, V>> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {

			Associacao<K, V> associacao = lista.get(i);

			if (associacao.getChave().equals(placa)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object chave) {
		int indice = this.calculaIndiceDaTabela((K) chave);

		List<Associacao<K, V>> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			Associacao<K, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				return associacao.getValor();
			}
		}

		throw new IllegalArgumentException("A chave não existe");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K chave, V valor) {

		if (this.containsKey(chave)) {
			this.remove(chave);
		}

		int indice = this.calculaIndiceDaTabela(chave);

		List<Associacao<K, V>> lista = this.tabela.get(indice);

		Associacao<K, V> associacao = new Associacao<K, V>(chave, valor);

		lista.add(associacao);

		return associacao.getValor();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public V remove(Object chave) {

		int indice = this.calculaIndiceDaTabela((K) chave);
		List<Associacao<K, V>> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			Associacao<K, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				lista.remove(i);
				return associacao.getValor();
			}
		}

		throw new IllegalArgumentException("A chave não existe");
	}

	@Override
	public int size() {
		Integer tamanhoTotal = 0;

		for (List<Associacao<K, V>> list : tabela) {
			tamanhoTotal += list.size();
		}

		return tamanhoTotal;
	}

	public Collection<Associacao<K, V>> pegarTodos() {

		ArrayList<Associacao<K, V>> associacoes = new ArrayList<Associacao<K, V>>();

		for (List<Associacao<K, V>> lista : this.tabela) {
			associacoes.addAll(lista);
		}

		return associacoes;
	}

	private int calculaIndiceDaTabela(K chave) {
		return Math.abs(chave.hashCode()) % this.tabela.size();
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
