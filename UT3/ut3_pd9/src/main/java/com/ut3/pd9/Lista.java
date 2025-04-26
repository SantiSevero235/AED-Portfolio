package com.ut3.pd9;

public class Lista<T> implements ILista<T> {
    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public void insertar(Nodo<T> nodo) {
        if (esVacia()) {
            primero = nodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    public void insertar (Comparable etiqueta, T dato ) {
        Nodo<T> nuevoNodo = new Nodo<T>(etiqueta, dato);
        if (esVacia()) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }

    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (primero != null) {
                if (primero.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        } else {
            if (primero.getSiguiente() == null) {
                if (primero.getEtiqueta().equals(clave)) {
                    primero = null;
                    return true;
                }
            }
        }
        Nodo<T> aux = primero;
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }


    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos: 0");
            return 0;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    public boolean esVacia() {
        return primero == null;
    }
    
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
}




