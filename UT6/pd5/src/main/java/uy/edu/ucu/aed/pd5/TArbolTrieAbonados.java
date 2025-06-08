package uy.edu.ucu.aed.pd5;

import java.util.Collections;
import java.util.LinkedList;

public class TArbolTrieAbonados {

    private TNodoTrieAbonados raiz = new TNodoTrieAbonados();

    public void insertar(String telefono, String nombre) {
        raiz.insertar(telefono, nombre);
    }

    public LinkedList<TAbonado> buscarTelefonos(String codigoPais, String codigoArea) {
        String prefijo = codigoPais + codigoArea;
        TNodoTrieAbonados nodo = raiz.buscarNodo(prefijo);
        LinkedList<TAbonado> resultado = new LinkedList<>();
        if (nodo != null) {
            nodo.recolectarAbonados(resultado);
            Collections.sort(resultado, (a1, a2) -> a1.getNombre().compareToIgnoreCase(a2.getNombre()));
        }
        return resultado;
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
}
