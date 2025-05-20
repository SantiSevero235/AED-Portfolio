package uy.edu.ucu.aed.pd7;

public class Lista<T> implements ILista<T> {

    protected class Nodo<T> {

        protected final Comparable etiqueta;
        protected T dato;
        protected Nodo<T> siguiente = null;

        public Nodo(Comparable etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> unElemento = new Nodo<T>(clave, dato);
        if (esVacia()) {
            primero = unElemento;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = unElemento;
        }
    }

    @Override
    public T buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> actual = primero;
            while (actual != null) {
                if (actual.etiqueta.equals(clave)) {
                    return actual.dato;
                } else {
                    actual = actual.siguiente;
                }
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.etiqueta.equals(clave)) {
            primero = primero.siguiente;
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.siguiente != null && !actual.siguiente.etiqueta.equals(clave)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente == null) {
            return false;
        }
        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.dato.toString());
            actual = actual.siguiente;
            if (actual != null) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.dato.toString());
            actual = actual.siguiente;
            if (actual != null) {
                sb.append(separador);
            }
        }
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return (primero == null);
    }

    public T buscarSiguiente(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.etiqueta.equals(clave)) {
                return (actual.siguiente != null) ? actual.siguiente.dato : null;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

}
