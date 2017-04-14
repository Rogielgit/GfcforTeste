import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

public class GFC {

	private static final String Caminho = "teste.java";

	public static void main(String args[]) throws Exception {

		GFC gfc = new GFC();
		String formatograph;
		CompilationUnit cu;
		Arquivo arquivo = new Arquivo();
		BufferedWriter escrita = arquivo.criaArquivo();
		try {
			cu = JavaParser.parse(new FileInputStream(Caminho));
			formatograph = (String) gfc.recebePrograma(cu.toString());
			arquivo.escreveArquivo(escrita, formatograph);

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "ERRO LÉXICO OU SINTÁTICO NO PROGRAMA ANALISADO");
		}
		Runtime r = Runtime.getRuntime();
		r.exec("dot graph.dot -Tpng -ografico.ong"); // gerar o grafico

	}

	public String recebePrograma(String programa) {
		int n = 1;
		String testador; // para saber a string que esta sendo retornada
		int cont1 = -2; // desconsidera os dois primeiros
		int valorTopo;
		int valorAtual;
		int contgeral = -2;
		int antvalorTopo = 0;
		int antvalorAtual = 0;
		int flag = 0;
		int estadoFinal = 0;
		int antPosicaoj = 0;

		int[] posiWhile = new int[10];
		int[] posifor = new int[10];
		int[] atulposiFor = new int[10];

		StringBuilder ligVertices = new StringBuilder();
		ligVertices.append("digraph {\n"); // para gerar o grafico

		int i = 0;
		int j = 0;
		System.out.println(posiWhile[0]);

		Pilha st = new Pilha();
		Stack pilha = new Stack();
		st.inserePilha(pilha, 1);// colocar em todos int,float e etc

		StringTokenizer token = new StringTokenizer(programa);
		while (token.hasMoreElements()) {
			testador = token.nextElement().toString();

			switch (testador) { // definição para palavras reservadas

			case "if":
				n++;
				break;
			case "else":
				n++;
				break;
			case "int": // definir todos os tipos
				break;
			case "for": // é necessario dois blocos
				n++;
				posifor[j] = n;
				j++;
				break;
			case "while":
				n++;
				posiWhile[i] = n;
				i++;
				break;
			case "try":
				n++;
				break;
			case "catch":
				n++;
				break;
			default:
				if (testador.equals("{")) {
					cont1++;
					contgeral++;
					if (cont1 > 0)
						st.inserePilha(pilha, n);
					antvalorAtual = n;
				} else if (testador.equals("}")) {
					contgeral--;
					valorAtual = st.removePilha(pilha);
					valorTopo = st.vertopo(pilha);
					if (valorAtual != 0 && valorTopo != 0) // pilha vazia
					{

						System.out.println(valorTopo + " -> " + valorAtual);
						ligVertices.append(valorTopo + " -> " + valorAtual + "\n");

						if (j > 0 && posifor[j - 1] != 0) {

							if (valorTopo == posifor[j - 1]) {
								if (antPosicaoj != j) {
									n++; // soma somente se achar outro for
									atulposiFor[j - 1] = n;
									antPosicaoj = j;
									ligVertices.append(atulposiFor[j - 1] + " -> " + posifor[j - 1] + "\n");

								}
								ligVertices.append(valorAtual + " -> " + atulposiFor[j - 1] + "\n");
							

							}

						} else if (i > 0 && posiWhile[i - 1] != 0) // para saber
																	// se os
						// comando estao
						// dentro de um //
						// while
						{

							if (valorTopo == posiWhile[i - 1]) {
								System.out.println(valorAtual + " -> " + valorTopo);
								ligVertices.append(antvalorAtual + " -> " + valorTopo + "\n");

							}

						}
					}
					if (contgeral == 0) {
						if (flag == 0) { // cria final somente uma vez
							estadoFinal = ++n;
							flag = 1;
						}

						ligVertices.append(valorAtual + " -> " + estadoFinal + "\n");
						System.out.println("ultimo " + n);
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
