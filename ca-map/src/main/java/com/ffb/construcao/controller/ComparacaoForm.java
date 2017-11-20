package com.ffb.construcao.controller;

import java.util.ArrayList;
import java.util.List;

public class ComparacaoForm {

	private List<String> tempoCaleum = new ArrayList<String>();
	private List<String> tempoFBuni = new ArrayList<String>();;
	private List<String> tempoJava = new ArrayList<String>();;

	public List<String> getTempoCaleum() {
		return tempoCaleum;
	}

	public void setTempoCaleum(List<String> tempoCaleum) {
		this.tempoCaleum = tempoCaleum;
	}

	public List<String> getTempoFBuni() {
		return tempoFBuni;
	}

	public void setTempoFBuni(List<String> tempoFBuni) {
		this.tempoFBuni = tempoFBuni;
	}

	public List<String> getTempoJava() {
		return tempoJava;
	}

	public void setTempoJava(List<String> tempoJava) {
		this.tempoJava = tempoJava;
	}

}
