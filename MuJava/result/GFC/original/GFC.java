// This is a mutant program.
// Author : ysma

package Gfc;


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


public class GFC
{

    private static final java.lang.String Caminho = "programa_de_entrada3.java";

    public static  void main( java.lang.String[] args )
        throws java.lang.Exception
    {
        Gfc.GFC gfc = new Gfc.GFC();
        java.lang.String formatograph;
        com.github.javaparser.ast.CompilationUnit cu;
        Gfc.Arquivo arquivo = new Gfc.Arquivo();
        java.io.BufferedWriter escrita = arquivo.criaArquivo();
        try {
            cu = JavaParser.parse( new java.io.FileInputStream( Caminho ) );
            formatograph = (java.lang.String) gfc.recebePrograma( cu.toString() );
            arquivo.escreveArquivo( escrita, formatograph );
        } catch ( com.github.javaparser.ParseException e ) {
            JOptionPane.showMessageDialog( null, "ERRO LÉXICO OU SINTÁTICO NO PROGRAMA ANALISADO.\n" + e );
        }
        java.lang.Runtime r = Runtime.getRuntime();
        r.exec( "dot graph.dot -Tpng -ografico.ong" );
        JOptionPane.showMessageDialog( null, "Gráfico de Fluxo de Controle gerado no arquivo grafico.png" );
    }

    public  java.lang.String recebePrograma( java.lang.String programa )
    {
        int n = 1;
        java.lang.String testador;
        int cont1 = -2;
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
        java.lang.StringBuilder ligVertices = new java.lang.StringBuilder();
        ligVertices.append( "digraph {\n" );
        int i = 0;
        int j = 0;
        Gfc.Pilha st = new Gfc.Pilha();
        java.util.Stack pilha = new java.util.Stack();
        st.inserePilha( pilha, 1 );
        java.util.StringTokenizer token = new java.util.StringTokenizer( programa );
        while (token.hasMoreElements()) {
            testador = token.nextElement().toString();
            switch (testador) {
            case "boolen" :
                break;

            case "byte" :
                break;

            case "short" :
                break;

            case "int" :
                break;

            case "long" :
                break;

            case "float" :
                break;

            case "double" :
                break;

            case "String" :
                break;

            case "if" :
                n++;
                break;

            case "else" :
                n++;
                break;

            case "for" :
                n++;
                posifor[j] = n;
                j++;
                break;

            case "while" :
                n++;
                posiWhile[i] = n;
                i++;
                break;

            case "try" :
                n++;
                break;

            case "catch" :
                n++;
                break;

            default  :
                if (testador.equals( "{" )) {
                    cont1++;
                    contgeral++;
                    if (cont1 > 0) {
                        st.inserePilha( pilha, n );
                    }
                    antvalorAtual = n;
                } else {
                    if (testador.equals( "}" )) {
                        contgeral--;
                        valorAtual = st.removePilha( pilha );
                        valorTopo = st.vertopo( pilha );
                        if (valorAtual != 0 && valorTopo != 0) {
                            ligVertices.append( valorTopo + " -> " + valorAtual + "\n" );
                            if (j > 0 && posifor[j - 1] != 0) {
                                if (valorTopo == posifor[j - 1]) {
                                    if (antPosicaoj != j) {
                                        n++;
                                        atulposiFor[j - 1] = n;
                                        antPosicaoj = j;
                                        ligVertices.append( atulposiFor[j - 1] + " -> " + posifor[j - 1] + "\n" );
                                    }
                                    ligVertices.append( valorAtual + " -> " + atulposiFor[j - 1] + "\n" );
                                }
                            } else {
                                if (i > 0 && posiWhile[i - 1] != 0) {
                                    if (valorTopo == posiWhile[i - 1]) {
                                        ligVertices.append( antvalorAtual + " -> " + valorTopo + "\n" );
                                    }
                                }
                            }
                        }
                        if (contgeral == 0) {
                            if (flag == 0) {
                                estadoFinal = ++n;
                                flag = 1;
                            }
                            ligVertices.append( valorAtual + " -> " + estadoFinal + "\n" );
                        }
                    }
                }
                break;

            }
        }
        ligVertices.append( "}" );
        System.out.println( ligVertices.toString() );
        return ligVertices.toString();
    }

}
