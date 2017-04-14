import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Arquivo { // classe para salva a saida para o graphviz ler
	public BufferedWriter criaArquivo() throws IOException {
		FileOutputStream file = new FileOutputStream("graph.dot");
		OutputStreamWriter osw = new OutputStreamWriter(file);  
		BufferedWriter escrita = new BufferedWriter(osw);
		return escrita;
		
	}
	public void escreveArquivo(BufferedWriter escrita, String string) throws IOException {

		escrita.write(string);
		escrita.close();
	}

}
