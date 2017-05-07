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
	public void criaArquivo(){
		arquivo = new Arquivo();
		//entrada = arquivo.criaArquivo();

	}

	@Test
	public void testeArquivo(){
		
		//entrada = arquivo.criaArquivo();
		try {
			System.out.println(arquivo.escreveArquivo(entrada, "rogiel"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals("rogiel", arquivo.escreveArquivo(entrada, "rogiel"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
