package uy.edu.ucu.aed.pd3;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            return 0;
        }
        return raiz.buscar(palabra);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz != null) {
            raiz.predecir(prefijo, palabras);
        }
        return palabras;
    }

    public void insertarConPag(String palabra, int pagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.añadirPalabraUnaPagina(palabra, pagina);
    }

    public void indizarLibro(String[] texto) {
        int pagina = 1;
        for (int i = 0; i < texto.length; i++) {
            if (i > 0 && i % 50 == 0) {
                pagina++;
            }
            String[] palabras = texto[i].split("\\W+");
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) {
                    palabra = TNodoTrie.filtrarPalabra(palabra);
                    this.insertarConPag(palabra, pagina);
                }
            }
        }
    }
    public String imprimirIndice() {
        StringBuilder str = new StringBuilder();
        if (raiz != null) {
            raiz.imprimirIndice("", str);
        }
        return str.toString();
    }

    public String buscarPalabraConOtrosDatos(String palabra) {
        StringBuilder str = new StringBuilder();
        if (raiz != null) {
            raiz.buscarPalabraConOtrosDatos(palabra, 0, str);
        }
        return str.toString();
    }
}