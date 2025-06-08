package uy.edu.ucu.aed.pd5;

import java.util.HashMap;
import java.util.Map;

public class TNodoTrieHashMap implements INodoTrie {

    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            char letra = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(letra)) {
                nodo.hijos.put(letra, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(letra);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (char letra : nodo.hijos.keySet()) {
                imprimir(s + letra, nodo.hijos.get(letra));
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int i = 0; i < s.length(); i++) {
            char letra = s.charAt(i);
            if (!nodo.hijos.containsKey(letra)) {
                return null;
            }
            nodo = nodo.hijos.get(letra);
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, HashMap<String, Integer> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.put(prefijo + s, 1); // valor 1 por defecto
            }
            for (Map.Entry<Character, TNodoTrieHashMap> entry : nodo.hijos.entrySet()) {
                predecir(s + entry.getKey(), prefijo, palabras, entry.getValue());
            }
        }
    }

    @Override
    public void predecir(String prefijo, HashMap<String, Integer> palabras) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir("", prefijo, palabras, nodo);
        }
    }


    @Override
    public int buscar(String s) {
        TNodoTrieHashMap nodo = this;
        int comparaciones = 0;

        for (int i = 0; i < s.length(); i++) {
            char letra = s.charAt(i);
            comparaciones++;
            if (!nodo.hijos.containsKey(letra)) {
                return 0;
            }
            nodo = nodo.hijos.get(letra);
        }
        return nodo.esPalabra ? comparaciones : 0;
    }
}
