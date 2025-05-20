package uy.edu.ucu.aed.pd7;

public class Conjunto<T> implements IConjunto<T> {

    private final Lista<T> elementos = new Lista<>();

    @Override
    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();

        // Copiar todos los elementos de this
        Lista<T>.Nodo<T> aux = this.elementos.getPrimero();
        while (aux != null) {
            resultado.insertar(aux.dato, aux.etiqueta);
            aux = aux.siguiente;
        }

        // Agregar los elementos de otroConjunto si no están ya
        Lista<T>.Nodo<T> aux2 = ((Conjunto<T>) otroConjunto).elementos.getPrimero();
        while (aux2 != null) {
            if (this.elementos.buscar(aux2.etiqueta) == null) {
                resultado.insertar(aux2.dato, aux2.etiqueta);
            }
            aux2 = aux2.siguiente;
        }

        return resultado;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();

        Lista<T>.Nodo<T> aux = this.elementos.getPrimero();
        while (aux != null) {
            if (((Conjunto<T>) otroConjunto).elementos.buscar(aux.etiqueta) != null) {
                resultado.insertar(aux.dato, aux.etiqueta);
            }
            aux = aux.siguiente;
        }

        return resultado;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        if (elementos.buscar(clave) == null) {
            elementos.insertar(dato, clave);
        }
    }

    @Override
    public T buscar(Comparable clave) {
        return elementos.buscar(clave);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return elementos.eliminar(clave);
    }

    @Override
    public String imprimir() {
        return elementos.imprimir();
    }

    @Override
    public String imprimir(String separador) {
        return elementos.imprimir(separador);
    }

    @Override
    public int cantElementos() {
        return elementos.cantElementos();
    }

    @Override
    public boolean esVacia() {
        return elementos.esVacia();
    }
}
