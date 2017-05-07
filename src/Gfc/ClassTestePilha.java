package Gfc;

import static org.junit.Assert.*;

import java.io.BufferedWriter;

import java.io.IOException;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class ClassTestePilha {

	private Pilha st;
	private Stack pilha;

	@Before
	public void setUp() {
		st = new Pilha();
		pilha = new Stack();
		st.inserePilha(pilha, 1);
	}

	@Test
	public void teste1() {
		assertEquals(1, st.removePilha(pilha));
	}

	@Test
	public void testeRemovevazio() {
		st.removePilha(pilha);
		assertEquals(0, st.removePilha(pilha));
	}

	@Test
	public void testeTamanho() {
		assertEquals(1, st.tamanhoPilha(pilha));

	}

	@Test
	public void testeVaziaTrue()
	{	st.removePilha(pilha);
		assertTrue(st.estavazia(pilha));
	}

	@Test
	public void testeVaziaFalse()
	{
		assertFalse(st.estavazia(pilha));
	}
	
	
	@Test
	public void testeVerTopo()
	{	assertEquals(1, st.vertopo(pilha));
		st.removePilha(pilha);
		assertEquals(0, st.vertopo(pilha));
	}

}
