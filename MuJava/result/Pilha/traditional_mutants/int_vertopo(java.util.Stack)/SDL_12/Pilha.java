// This is a mutant program.
// Author : ysma

package Gfc;


import java.util.Stack;


public class Pilha
{

    public  void inserePilha( java.util.Stack pilha, int valor )
    {
        pilha.push( new java.lang.Integer( valor ) );
    }

    public  int removePilha( java.util.Stack pilha )
    {
        if (pilha.isEmpty() == false) {
            java.lang.Integer valor = (java.lang.Integer) pilha.pop();
            return valor;
        }
        return 0;
    }

    public  boolean estavazia( java.util.Stack pilha )
    {
        if (pilha.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }

    public  int vertopo( java.util.Stack pilha )
    {
        java.lang.Integer valor;
        if (true) {
            valor = (java.lang.Integer) pilha.pop();
            pilha.push( new java.lang.Integer( valor ) );
            return valor;
        }
        return 0;
    }

    public  int tamanhoPilha( java.util.Stack pilha )
    {
        return pilha.size();
    }

}
