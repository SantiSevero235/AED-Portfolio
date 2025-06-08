package uy.edu.ucu.aed.pd5;

import java.util.HashMap;
import java.util.List;

public class TNodoTrieAbonados {

    private HashMap<Character, TNodoTrieAbonados> hijos;
    private boolean esAbonado;
    private String nombreAbonado;
    private String telefono;

    public TNodoTrieAbonados() {
        hijos = new HashMap<>();
        esAbonado = false;
    }

    public void insertar(String telefono, String nombre) {
        TNodoTrieAbonados nodo = this;
        for (char c : telefono.toCharArray()) {
            nodo.hijos.putIfAbsent(c, new TNodoTrieAbonados());
            nodo = nodo.hijos.get(c);
        }
        nodo.esAbonado = true;
        nodo.nombreAbonado = nombre;
        nodo.telefono = telefono;
    }

    public TNodoTrieAbonados buscarNodo(String prefijo) {
        TNodoTrieAbonados nodo = this;
        for (char c : prefijo.toCharArray()) {
            nodo = nodo.hijos.get(c);
            if (nodo == null) return null;
        }
        return nodo;
    }

    public void recolectarAbonados(List<TAbonado> lista) {
        if (this.esAbonado) {
            lista.add(new TAbonado(nombreAbonado, telefono));
        }
        for (TNodoTrieAbonados hijo : hijos.values()) {
            hijo.recolectarAbonados(lista);
        }
    }

    public void imprimir() {
        imprimir("", this);
    }

    private void imprimir(String prefijo, TNodoTrieAbonados nodo) {
        if (nodo.esAbonado) {
            System.out.println(nodo.nombreAbonado + ", " + nodo.telefono);
        }
        for (Character c : nodo.hijos.keySet()) {
            imprimir(prefijo + c, nodo.hijos.get(c));
        }
    }
}
