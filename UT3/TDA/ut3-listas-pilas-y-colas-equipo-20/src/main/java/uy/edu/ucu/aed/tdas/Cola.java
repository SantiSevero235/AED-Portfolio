package uy.edu.ucu.aed.tdas;

public class Cola<T> extends Lista<T> implements ICola<T> {

    public Cola() {
        primero = null;
    }

    @Override
    public void anular() {
        primero = null; // Vacía la cola
    }

    @Override
    public T frente() {
        if (vacia()) {
            return null;
        }
        return primero.getDato(); // Devuelve el primer elemento de la cola
    }

    @Override
    public void poneEnCola(T unElemento) {
        Nodo nuevoNodo = new Nodo(unElemento);
        if (vacia()) {
            primero = nuevoNodo; // En el caso de que la cola sea vacía el nodo creado pasa a ser el primero de la cola
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) { // Se recorre la cola hasta llegar al final
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo); // Se agrega el nuevo nodo al final
        }
    }

    @Override
    public T quitaDeCola() {
        if (vacia()) {
            return null;
        }
        T dato = primero.getDato();
        primero = primero.getSiguiente();
        return dato;
    }


    public void imprimirCola() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato());
            if (actual.getSiguiente() != null) {
                System.out.print(", ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println(); // Salto de línea final
    }

}
