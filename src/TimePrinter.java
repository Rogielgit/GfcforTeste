import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.sun.javafx.scene.paint.GradientUtils.Parser;
import com.sun.xml.internal.bind.v2.model.nav.Navigator;

public class TimePrinter {

	private String programa;
	private static final String Caminho = "teste.java";

	public static void main(String args[]) throws Exception {

		TimePrinter timePrinter = new TimePrinter();

		CompilationUnit cu = JavaParser.parse(new FileInputStream(Caminho));
		System.out.println(cu.getChildrenNodes());
		timePrinter.recebePrograma(cu.toString());

	}

	public void recebePrograma(String programa) {
		int n = 1;
		String testador; // para saber a string que esta sendo retornada
		String stringAnterior1 = " ";
		String stringAnterior2;
		int cont1 = -2; // desconsidera os dois primeiros
		int cont2 = 0;
		int posiFor = -1;

		StringTokenizer token = new StringTokenizer(programa);
		while (token.hasMoreElements()) {
			testador = token.nextElement().toString();
			stringAnterior2 = stringAnterior1;
			stringAnterior1 = testador;

			System.out.println(testador);

			switch (testador) {

			case "if":
				n++;
				System.out.println(testador + " --> " + n);
				break;
			case "else":
				n++;
				System.out.println(testador + " --> " + n);
				break;
			case "int": // definir todos os tipos
				System.out.println(testador + " --> " + n);
				break;
			case "for": // é necessario dois blocos

				n++;
				posiFor = n;
				System.out.println(testador + " --> " + n);
				n++;
				System.out.println(testador + " --> " + n);
			case "while":
				n++;
				System.out.println(testador + " --> " + n);

			default:

				if (testador.equals("{"))
					cont1++;
				else if (testador.equals("}"))
					cont2++;

				if (cont1 == cont2 && cont1!=0) { // tentando usar os delimitadores {} para saber aonde começa o proximo comando
					System.out.println(posiFor + " -> " + n);
				}

				/*
				 * //System.out.println(testador + " --> " + n); if
				 * (stringAnterior1.equals("}")) { n++;
				 * System.out.println(testador + " --> " + n); } else if
				 * (stringAnterior1.equals("{") && stringAnterior2.equals(" ")){
				 * n++; //System.out.println(testador + " --> 2 " + n); }
				 */
				break;

			}

			// System.out.println(token.nextElement() +" --> " + n);

		}
		// System.out.println("contador: " + cont/;

	}

}
