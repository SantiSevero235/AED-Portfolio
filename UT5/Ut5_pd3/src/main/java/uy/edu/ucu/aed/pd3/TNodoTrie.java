package uy.edu.ucu.aed.pd3;

import java.util.ArrayList;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private final static int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    public ArrayList<Integer> paginas;
    private boolean finPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;

        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir("", prefijo, palabras, nodo);
        }
    }

    @Override
    public int buscar(String s) {
        TNodoTrie nodo = this;
        int comparaciones = 0;

        for (int i = 0; i < s.length(); i++) {
            int indice = s.charAt(i) - 'a';
            comparaciones++;
            if (nodo.hijos[indice] == null) {
                return 0;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo.esPalabra ? comparaciones : 0;
    }

    public void buscarPalabraConOtrosDatos(String unaPalabra, int cantidad, StringBuilder str) {
        TNodoTrie nodoActual = this;
        for (char car : unaPalabra.toCharArray()) {
            cantidad++;
            TNodoTrie unHijo = nodoActual.hijos[obtenerHijo(car)];
            if (unHijo == null) {
                str.append("Palabra: ").append(unaPalabra).append(" no encontrada.");
                return;
            } else {
                nodoActual = unHijo;
            }
        }
        str.append("Palabra: ").append(unaPalabra).append(" Cantidad: ").append(cantidad).append(" - Paginas: ");
        if (nodoActual.finPalabra) {
            for (int i = 0; i < nodoActual.paginas.size(); i++) {
                str.append(nodoActual.paginas.get(i)).append(" ");
            }
        }
    }public static String filtrarPalabra(String unaPalabra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < unaPalabra.length(); i++) {
            char caracter = unaPalabra.charAt(i);
            if ((caracter >= 'A' && caracter <= 'Z') ||
                    (caracter >= 'a' && caracter <= 'z'))
                sb.append(caracter);
        }

        return sb.toString().toLowerCase();
    }

    public int obtenerHijo(char caracter){
        int indice = caracter - 'a';
        return indice;
    }


    public boolean añadirPalabraUnaPagina(String unaPalabra, int pagina) {
        TNodoTrie nodoActual = this;
        for (char car : unaPalabra.toCharArray()) {
            TNodoTrie unHijo = nodoActual.hijos[obtenerHijo(car)];
            if (unHijo == null) {
                unHijo = new TNodoTrie();
                nodoActual.hijos[obtenerHijo(car)] = unHijo;
            }
            nodoActual = unHijo;
        }
        nodoActual.finPalabra = true;
        if (nodoActual.paginas == null) { // Verificación redundante pero por seguridad
            nodoActual.paginas = new ArrayList<>();
        }
        nodoActual.paginas.add(pagina);
        return true;
    }

    public void imprimirIndice(String prefijo, StringBuilder str) {
        TNodoTrie nodo = this;
        if (nodo == null) {
            return;
        }
        if (nodo.finPalabra) {
            str.append(prefijo + " ");
            for (int p=0;p<nodo.paginas.size();p++){
                str.append(nodo.paginas.get(p) + " ");
            }
            str.append("\n");
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (nodo.hijos[i] != null){
                nodo.hijos[i].imprimirIndice(prefijo + c, str);
            }
        }
    }
}
