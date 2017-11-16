package com.ffb.construcao.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class HashMapCaelumTest {

	Map<String, Object> map;

	@Before
	public void inciar() {

		map = new HashMapCaelum<String, Object>();

		System.out.println("### HASH MAP DA CAELUM criado com sucesso ###");
	}

	@Test
	public void testo_insercao_de_valores_no_map() {
		assertEquals(map.put("chave 1", "valor 1"), "valor 1");
	}

}
