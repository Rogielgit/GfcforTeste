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
		StringTokenizer token = new StringTokenizer(programa, " ");
		while (token.hasMoreElements()) {

			testador = token.nextElement().toString();
			// System.out.println(testador +" --> " + n);

			switch (testador) {

			case "if":
				n++;
				System.out.println(testador + " --> " + n);
				break;
			case "else":
				n++;
				System.out.println(testador + " --> " + n);
				break;
			case "int":
				System.out.println(testador + " --> " + n);
				break;
			default:
				break;
			}

			// System.out.println(token.nextElement() +" --> " + n);

		}

	}

}
