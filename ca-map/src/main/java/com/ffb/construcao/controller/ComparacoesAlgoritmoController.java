package com.ffb.construcao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffb.construcao.modelo.HashMapCaelum;
import com.ffb.construcao.modelo.MeuHashMap;

@Controller
@RequestMapping("/comparar")
public class ComparacoesAlgoritmoController {

	@RequestMapping("/")
	public String iniciar() {
		return "comparar";
	}

	@RequestMapping(value = "/executar-algoritmo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> executarAlgoritmos(@RequestBody Integer qtd)
			throws Exception {

		Map<String, Object> retorno = new HashMap<String, Object>();

		retorno.put("tempoMeu",
				calcularTempo(qtd, new MeuHashMap<String, Object>()));

		retorno.put("tempoCaelum",
				calcularTempo(qtd, new HashMapCaelum<String, Object>()));

		retorno.put("tempoJava",
				calcularTempo(qtd, new HashMap<String, Object>()));

		return retorno;
	}

	private long calcularTempo(Integer quantidadeDeInsercoes,
			Map<String, Object> implementacaoMap) {

		long start = System.currentTimeMillis();

		for (Integer i = 0; i < quantidadeDeInsercoes; i++) {
			implementacaoMap.put(i.toString(), i);

		}
		return System.currentTimeMillis() - start;
	}
}
