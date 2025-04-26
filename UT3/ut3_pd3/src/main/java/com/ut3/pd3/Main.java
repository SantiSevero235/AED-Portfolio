package com.ut3.pd3;

public class Main {
    public static void main(String[] args) {
        // Crear una nueva lista
        Lista<String> lista = new Lista<>();

        // Insertar algunos elementos en la lista
        lista.insertar("A", "Primer Elemento");
        lista.insertar("B", "Segundo Elemento");
        lista.insertar("C", "Tercer Elemento");
        lista.insertar("D", "Cuarto Elemento");

        // Imprimir la lista
        System.out.println("Lista después de las inserciones:");
        System.out.println(lista.imprimir(" -> "));

        // Buscar un elemento en la lista
        Nodo<String> nodoEncontrado = lista.buscar("A");
        if (nodoEncontrado != null) {
            System.out.println("Elemento encontrado: " + nodoEncontrado.getDato());
        } else {
            System.out.println("Elemento no encontrado.");
        }

        // Eliminar un elemento de la lista
        boolean eliminado = lista.eliminar("B");
        if (eliminado) {
            System.out.println("Elemento eliminado.");
        } else {
            System.out.println("Elemento no encontrado.");
        }

        // Imprimir la lista después de la eliminación
        System.out.println("Lista después de la eliminación:");
        System.out.println(lista.imprimir(" -> "));

        // Imprimir la cantidad de elementos
        System.out.println("Cantidad de elementos en la lista: " + lista.cantElementos());

        boolean eliminado2 = lista.eliminar("C");
        if (eliminado2) {
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento no encontrado");
        }

        // Imprimir la lista con la segunda eliminación
        System.out.println("Con segunda eliminación:");
        System.out.println(lista.imprimir(" -> "));
    }
}
