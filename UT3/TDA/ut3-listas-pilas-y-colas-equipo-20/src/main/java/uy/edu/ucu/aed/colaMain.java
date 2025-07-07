package uy.edu.ucu.aed;

import uy.edu.ucu.aed.tdas.Cola;

public class colaMain {
    public static void main (String[] args) {
        Cola<String> cola = new Cola<>();

        cola.poneEnCola("Coca-Cola");
        cola.poneEnCola("Sandwiches");
        cola.poneEnCola("Helado Crufi Light");

        cola.imprimirCola();

        System.out.println("El frente de la Cola es: " + cola.frente());

        System.out.println("Está vacía? " + cola.vacia());

        System.out.println("Se elimina el elemento: " + cola.quitaDeCola());

        System.out.println("Ahora el frente es: " + cola.frente());

        cola.imprimirCola();

        cola.anular(); // Vaciamos la cola

        System.out.println("Está vacía? " + cola.vacia()); // Verificamos que está vacía


    }
}
