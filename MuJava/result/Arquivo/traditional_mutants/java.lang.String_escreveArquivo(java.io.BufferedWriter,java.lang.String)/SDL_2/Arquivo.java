// This is a mutant program.
// Author : ysma

package Gfc;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Arquivo
{

    public  java.io.BufferedWriter criaArquivo()
        throws java.io.IOException
    {
        java.io.FileOutputStream file = new java.io.FileOutputStream( "graph.dot" );
        java.io.OutputStreamWriter osw = new java.io.OutputStreamWriter( file );
        java.io.BufferedWriter escrita = new java.io.BufferedWriter( osw );
        return escrita;
    }

     java.lang.String escreveArquivo( java.io.BufferedWriter escrita, java.lang.String string )
        throws java.io.IOException
    {
        escrita.write( string );
        return string;
    }

}
