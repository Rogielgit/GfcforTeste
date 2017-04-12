import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;


public class TimePrinter {
	
			
	private static final String Caminho = "teste.java";

	public static void main(String args[]) throws Exception {

		TimePrinter timePrinter = new TimePrinter();
		String formatograph;
		Arquivo arquivo = new Arquivo();
		BufferedWriter escrita = arquivo.criaArquivo();
			
		CompilationUnit cu = JavaParser.parse(new FileInputStream(Caminho));
		System.out.println(cu.getChildrenNodes());
		formatograph = (String) timePrinter.recebePrograma(cu.toString());
		arquivo.escreveArquivo(escrita, formatograph);
		

		Runtime r = Runtime.getRuntime();
		r.exec("dot graph.dot -Tpng -ografico.ong"); // gerar o grafico
		

	}

	public String recebePrograma(String programa) {
		int n = 1;
		String testador; // para saber a string que esta sendo retornada		
		int cont1 = -2; // desconsidera os dois primeiros		
		int valorTopo;
		int valorAtual;
		StringBuilder ligVertices = new StringBuilder();
		ligVertices.append("digraph {\n"); // para gerar o grafico

		Pilha st = new Pilha();
		Stack pilha = new Stack();
		st.inserePilha(pilha, 1);// colocar em todos int,float e etc
		
		StringTokenizer token = new StringTokenizer(programa);
		while (token.hasMoreElements()) {
			testador = token.nextElement().toString();

			switch (testador) {

			case "if":
				n++;
				//System.out.println(testador + " --> " + n);
				break;
			case "else":
				n++;
				//System.out.println(testador + " --> " + n);
				break;
			case "int": // definir todos os tipos
				//System.out.println(testador + " --> " + n);
				break;
			case "for": // é necessario dois blocos
				n++;
				//System.out.println((n + 1) + " --> " + n);
				//System.out.println(testador + " --> " + n);
				n++;
				//System.out.println(testador + " --> " + n);
				break;
			case "while":
				n++;
				//System.out.println(testador + " --> " + n);
				break;
			default:
				if (testador.equals("{")) {
					cont1++;
					if (cont1 > 0)
						st.inserePilha(pilha, n);
				} else if (testador.equals("}")) {

					valorAtual = st.removePilha(pilha);
					valorTopo = st.vertopo(pilha);
					if (valorAtual != 0 && valorTopo != 0) // pilha vazia
					{

						System.out.println(valorTopo + " -> " + valorAtual);
						ligVertices.append(valorTopo + " -> " + valorAtual+"\n");
					}

				}
				break;

			}

		}
		ligVertices.append("}");	
		System.out.println(ligVertices);
		return ligVertices.toString();
	}

}
