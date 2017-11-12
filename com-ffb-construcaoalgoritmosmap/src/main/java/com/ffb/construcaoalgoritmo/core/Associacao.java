package com.ffb.construcaoalgoritmo.core;

public class Associacao<K, V> {

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

}
