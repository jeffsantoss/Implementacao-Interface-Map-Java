package com.ffb.construcao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comparar")
public class ComparacoesAlgoritmoController {

	@RequestMapping("/")
	public String iniciar() {
		return "comparar";
	}

	@RequestMapping(value = "/executar-algoritmo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> executarAlgoritmos(@RequestBody Integer qtd) {

		Map<String, Object> retorno = new HashMap<String, Object>();

		return retorno;
	}
}
