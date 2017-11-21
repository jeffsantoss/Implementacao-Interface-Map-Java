package com.ffb.construcao.modelo.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ffb.construcao.modelo.MeuHashMap;

public class MeuHashMapTest {

	Map<String, Object> meuMap;

	@Before
	public void iniciar() {
		meuMap = new MeuHashMap<String, Object>();
	}

	@Test
	public void posso_inserir_elemento() {
		meuMap.put("50", 50);
	}

	@Test
	public void posso_obter_elemento_a_partir_da_chave() {

		meuMap.put("1", 1);

		assertEquals(1, meuMap.get("1"));
	}

	@Test
	public void retorno_true_se_ja_existe_uma_chave() {

		meuMap.put("1", 1);

		assertTrue(meuMap.containsKey("1"));
	}

	@Test
	public void retorno_false_se_nao_existe_uma_chave() {

		meuMap.put("1", 1);

		assertFalse(meuMap.containsKey("2"));
	}

	@Test
	public void posso_obter_todos_os_valores() {

		meuMap.put("1", 1);
		meuMap.put("2", 11);
		meuMap.put("3", 152);

		Collection<?> valores = meuMap.values();

		assertEquals(3, valores.size());

	}

	@Test
	public void posso_inserir_1000000_elementos_e_resgatar_algum() {

		for (Integer i = 0; i < 17001000; i++) {
			System.out.println("inserindo.. " + i.toString());
			meuMap.put(i.toString(), i);
		}
	}

	@Test
	public void posso_obter_o_tamanho_do_map() {

		for (Integer i = 0; i < 1000000; i++) {
			meuMap.put(i.toString(), i);
		}

		assertEquals(1000000, meuMap.size());

	}

}
