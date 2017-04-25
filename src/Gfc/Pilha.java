package Gfc;
import java.util.Stack;

import com.sun.xml.internal.ws.util.pipe.StandalonePipeAssembler;

public class Pilha {// para empilhar a ocorrência de { e }
	public void inserePilha(Stack pilha, int valor) {
		pilha.push(new Integer(valor));

	}

	public int removePilha(Stack pilha) {
		if (pilha.isEmpty() == false) {
			Integer valor = (Integer) pilha.pop();
			return valor;
		}
		return 0;

	}

	public boolean estavazia(Stack pilha) {
		if (pilha.isEmpty() == true)
			return true;
		else
			return false;
	}

	public int vertopo(Stack pilha) {
		Integer valor;
		if (pilha.isEmpty() == false) {
			valor = (Integer) pilha.pop();
			pilha.push(new Integer(valor));
			return valor;
		}
		return 0;

	}

	public int tamanhoPilha(Stack pilha) {
		return pilha.size();

	}

}
