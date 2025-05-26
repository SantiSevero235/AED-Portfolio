package uy.edu.ucu.aed.pd3;

import java.util.ArrayList;
import java.util.List;

public class TNodoArbolGenerico<T> {
    private String etiqueta;
    private List<TNodoArbolGenerico<T>> hijos;
    private T dato;

    public TNodoArbolGenerico(String etiqueta) {
        this.etiqueta = etiqueta;
        this.hijos = new ArrayList<>();
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public List<TNodoArbolGenerico<T>> getHijos() {
        return hijos;
    }

    public void insertar(String etiquetaNuevoNodo) {
        TNodoArbolGenerico<T> nuevoNodo = new TNodoArbolGenerico<>(etiquetaNuevoNodo);
        hijos.add(nuevoNodo);
    }

    public TNodoArbolGenerico<T> buscar(String etiquetaBuscada) {
        if (this.etiqueta.equals(etiquetaBuscada)) {
            return this;
        }
        for (TNodoArbolGenerico<T> hijo : hijos) {
            TNodoArbolGenerico<T> resultado = hijo.buscar(etiquetaBuscada);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    public String listarIndentado(int nivel) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nivel; i++) {
            sb.append("  "); // dos espacios para la indentación
        }
        sb.append(etiqueta).append(" - \n");
        for (TNodoArbolGenerico<T> hijo : hijos) {
            sb.append(hijo.listarIndentado(nivel + 1));
        }
        return sb.toString();
    }
}
