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
	public void teste1()
	{
		assertEquals(2,st.removePilha(pilha));
	}

}
