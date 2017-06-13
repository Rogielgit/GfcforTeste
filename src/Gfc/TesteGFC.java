package Gfc;


import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

public class TesteGFC {
	
	GFC gfc;
	String formatograph;
	public CompilationUnit cu;
	String Caminho = "programa_de_entrada3.java"; //especificar aqui o programa que queremos testar

	
	@Before
	public void setUp() throws FileNotFoundException 
	{
		gfc = new GFC();		
		try {
			cu = JavaParser.parse(new FileInputStream(Caminho));

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "ERRO LÉXICO OU SINTÁTICO NO PROGRAMA ANALISADO.\n" + e);
		}
	}
	@Test
	public void testeIfElse()
	{
	
		assertEquals("digraph {\n"
				+ "1 -> 2\n"
				+ "2 -> 3\n"
				+ "1 -> 4\n"
				+ "4 -> 3\n"
				+ "}",gfc.recebePrograma(cu.toString()));
	
	}
	@Test
	public void TesteWhile() 
	{
		assertEquals("digraph {\n"
				+ "2 -> 3\n"
				+ "3 -> 2\n"
				+ "2 -> 4\n"
				+ "4 -> 2\n"
				+ "1 -> 2\n"
				+ "2 -> 5\n"
				+ "}", (String) gfc.recebePrograma(cu.toString()));
	}
	@Test
	public void TestFor(){
		
		assertEquals("digraph {\n"
				+ "2 -> 3\n"
				+ "4 -> 2\n"
				+ "3 -> 4\n"
				+ "2 -> 5\n"
				+ "5 -> 4\n"
				+ "1 -> 2\n"
				+ "2 -> 6\n"
				+ "}", gfc.recebePrograma(cu.toString()));
	}

}
