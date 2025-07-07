package uy.edu.ucu.aed;

import uy.edu.ucu.aed.tdas.Lista;

public class Main {
    public static void main (String[] args) {
        Lista<Integer> listaEnteros = new Lista<>();
        Lista<Integer> listaVacia = new Lista<>();

        listaEnteros.insertar(10,1);
        listaEnteros.insertar(20,2);
        listaEnteros.insertar(30,3);

        System.out.println(listaEnteros.imprimir());

        listaEnteros.eliminar(3);

        System.out.println(listaEnteros.imprimir(";"));

        System.out.println(listaEnteros.buscar(2));

        System.out.println(listaEnteros.cantElementos());

        System.out.println(listaEnteros.esVacia());
        System.out.println(listaVacia.esVacia());
    }
}
