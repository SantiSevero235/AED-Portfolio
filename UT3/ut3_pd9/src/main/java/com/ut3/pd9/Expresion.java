package com.ut3.pd9;

public class Expresion {

    public boolean controlCorchetes(String[] listaEntradas) {
        Lista<String> listaVerificar = new Lista<>();
        for (String i : listaEntradas) {
            if (i.equals("{")) {
                Nodo<String> a = new Nodo<>(i, "{");
                listaVerificar.insertar(a);
            } else if (i.equals("}")) {
                if (listaVerificar.esVacia()) {
                    return false; // Si hay un corchete de cierre sin un corchete de apertura correspondiente, están desbalanceados
                } else {
                    listaVerificar.eliminar("{"); // Eliminar el último corchete de apertura
                }
            }
        }
        // Si la lista está vacía al final, significa que todos los corchetes están balanceados
        return listaVerificar.esVacia();
    }
}
