package Gfc;
import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ClassTesteArquivo {	
	

	private Arquivo arquivo;

	private BufferedWriter entrada;

	@Before
	public void criaArquivo() throws IOException{
		arquivo = new Arquivo();
		entrada = arquivo.criaArquivo();

	}

	@Test
	public void testeArquivo() throws IOException{
		
		/*digraph {
			1 -> 2
			2 -> 3
			1 -> 4
			4 -> 3
			}*/
		assertEquals("digraph {1 -> 2"
				+ "2 -> 3"
				+ "1 -> 4"
				+ "4 -> 3"
				+ "}", arquivo.escreveArquivo(entrada, "digraph {1 -> 2"
						+ "2 -> 3"
						+ "1 -> 4"
						+ "4 -> 3"
						+ "}"));

	}
}
