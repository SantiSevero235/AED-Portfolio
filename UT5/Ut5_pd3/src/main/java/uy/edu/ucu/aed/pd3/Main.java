package uy.edu.ucu.aed.pd3;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        TArbolTrie t = new TArbolTrie();

        String[] str = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/pd3/libro.txt");
        t.indizarLibro(str);
        System.out.println(t.imprimirIndice());

        System.out.println(t.buscarPalabraConOtrosDatos("dead"));

    }
}