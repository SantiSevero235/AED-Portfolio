package uy.edu.ucu.aed.tdas;



public class Lista<T> implements ILista<T> {

    protected class Nodo {
        private T dato;
        private Comparable etiqueta;
        private Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
        }

        public Nodo(Comparable etiqueta, T dato) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }

        public T getDato() { return dato; }
        public void setDato(T dato) { this.dato = dato; }

        public Comparable getEtiqueta() { return etiqueta; }
        public void setEtiqueta(Comparable etiqueta) { this.etiqueta = etiqueta; }

        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    protected Nodo primero;

    public Nodo getPrimero() {
        return primero;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo unElemento = new Nodo(clave, dato);
        if (esVacia()) {
            primero = unElemento;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(unElemento);
        }
    }

    @Override
    public T buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo actual = primero;
            while (actual != null) {
                if (actual.getEtiqueta().equals(clave)) {
                    return actual.getDato();
                } else {
                    actual = actual.getSiguiente();
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
        if (primero.getEtiqueta().equals(clave)) {
            primero = primero.getSiguiente();
            return true;
        }
        Nodo actual = primero;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getEtiqueta().equals(clave)) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() == null) {
            return false;
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        return true;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = primero;
        while (actual != null) {
            sb.append(actual.getDato().toString());
            actual = actual.getSiguiente();
            if (actual != null) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        Nodo actual = primero;
        while (actual != null) {
            sb.append(actual.getDato().toString());
            actual = actual.getSiguiente();
            if (actual != null) {
                sb.append(separador);
            }
        }
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return (primero == null);
    }

    @Override
    public boolean vacia() {
    return esVacia(); // hace de alias para metodos como cola que usan vacia
    }

}
