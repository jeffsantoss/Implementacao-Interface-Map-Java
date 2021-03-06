package com.ffb.construcao.modelo;

public class Associacao<K, V> implements Comparable<Associacao<K, V>> {

	private K chave;
	private V valor;

	public Associacao(K chave, V valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public K getChave() {
		return chave;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public void setChave(K chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return "Associacao [chave=" + chave + ", valor=" + valor + "]";
	}

	@Override
	public int compareTo(Associacao<K, V> o) {
		if (this.chave.hashCode() < o.chave.hashCode())
			return -1;
		if (this.chave.hashCode() > o.chave.hashCode())
			return 1;

		return 0;
	}

}
