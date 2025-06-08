package uy.edu.ucu.aed.pd5;

import java.util.HashMap;


public class TTrieHashMap implements IArbolTrie {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
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
    public HashMap<String, Integer> predecir(String prefijo) {
        HashMap<String, Integer> resultados = new HashMap<>();
        if (raiz != null && prefijo != null && !prefijo.isEmpty()) {
            raiz.predecir(prefijo, resultados);
        }
        return resultados;
    }

}