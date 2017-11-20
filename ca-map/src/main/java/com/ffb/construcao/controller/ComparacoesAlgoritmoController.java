package com.ffb.construcao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ffb.construcao.modelo.HashMapCaelum;
import com.ffb.construcao.modelo.MeuHashMap;
import com.ffb.construcao.util.Util;

@Controller
@RequestMapping("/comparar")
public class ComparacoesAlgoritmoController {

	@RequestMapping("/")
	public ModelAndView iniciar() {

		ComparacaoForm form = new ComparacaoForm();

		// 10.000
		form.getTempoCaleum().add(Util.calcularTempoInsercao(10000,
				new HashMapCaelum<String, Object>()));

		// 100.000
		form.getTempoCaleum().add(Util.calcularTempoInsercao(100000,
				new HashMapCaelum<String, Object>()));

		// // 1.000.000
		// form.getTempoCaleum().add(Util.calcularTempoInsercao(100000,
		// new HashMapCaelum<String, Object>()));
		//
		// 10.000
		form.getTempoFBuni().add(Util.calcularTempoInsercao(10000,
				new MeuHashMap<String, Object>()));

		// 100.000
		form.getTempoFBuni().add(Util.calcularTempoInsercao(100000,
				new MeuHashMap<String, Object>()));

		// 1.000.000
		form.getTempoFBuni().add(Util.calcularTempoInsercao(100000,
				new MeuHashMap<String, Object>()));

		// 10.000
		form.getTempoJava().add(Util.calcularTempoInsercao(10000,
				new HashMap<String, Object>()));

		// 100.000
		form.getTempoJava().add(Util.calcularTempoInsercao(100000,
				new HashMap<String, Object>()));

		// 1.000.000
		form.getTempoJava().add(Util.calcularTempoInsercao(100000,
				new HashMap<String, Object>()));

		return ModelAndView("comparar", "form", form);
	}

	@RequestMapping(value = "/executar-algoritmo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> executarAlgoritmos(@RequestBody Integer qtd)
			throws Exception {

		Map<String, Object> retorno = new HashMap<String, Object>();

		retorno.put("tempoMeu", Util.calcularTempoInsercao(qtd,
				new MeuHashMap<String, Object>()));

		retorno.put("tempoCaelum", Util.calcularTempoInsercao(qtd,
				new HashMapCaelum<String, Object>()));

		retorno.put("tempoJava",
				Util.calcularTempoInsercao(qtd, new HashMap<String, Object>()));

		return retorno;
	}

	@RequestMapping(value = "/comparar-com-valores-fixos", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> comparar(@RequestBody Integer qtd)
			throws Exception {

		Map<String, Object> retorno = new HashMap<String, Object>();

		retorno.put("tempoMeu", Util.calcularTempoInsercao(qtd,
				new MeuHashMap<String, Object>()));

		retorno.put("tempoCaelum", Util.calcularTempoInsercao(qtd,
				new HashMapCaelum<String, Object>()));

		retorno.put("tempoJava",
				Util.calcularTempoInsercao(qtd, new HashMap<String, Object>()));

		return retorno;
	}

}
