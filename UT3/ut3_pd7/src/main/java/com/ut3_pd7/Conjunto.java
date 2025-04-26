package com.ut3_pd7;

public class Conjunto<T> implements IConjunto{
    private Nodo<T> primero;

    private Nodo<T> ultimo;

    private int cantidadElementos;
    public Conjunto() {
        primero = null;
        cantidadElementos = 0;
    }


    @Override
    public IConjunto union(IConjunto otroConjunto) {
        Conjunto<T> conjuntoAux = new Conjunto<>();
        Nodo<T> aux = primero;

        while (aux != null) {
            conjuntoAux.insertar(new Nodo<T>(aux.getEtiqueta(), aux.getDato()));
            aux = aux.getSiguiente();
        }

        Nodo<T> aux1 =otroConjunto.obtenerPrimerNodo();
        while (aux1 != null) {
            if (buscar(aux1.getEtiqueta()) == null) {
                conjuntoAux.insertar(new Nodo<T>(aux1.getEtiqueta(), aux1.getDato()));
            }
            aux1 = aux1.getSiguiente();
        }
        return conjuntoAux;
    }

    @Override
    public IConjunto interseccion(IConjunto otroConjunto) {
        Conjunto<T> conjuntoAux = new Conjunto<>();
        Nodo<T> aux1 = otroConjunto.obtenerPrimerNodo();

        while (aux1 != null) {
            if (buscar(aux1.getEtiqueta()) != null) {
                conjuntoAux.insertar(new Nodo<T>(aux1.getEtiqueta(), aux1.getDato()));
            }
            aux1 = aux1.getSiguiente();
        }
        return conjuntoAux;
    }

    @Override
    public Nodo obtenerPrimerNodo() {
        return primero;
    }

    @Override
    public void insertar(Nodo nodo) {
        if (esVacia()) {
            cantidadElementos++;
            primero = nodo;
            ultimo = nodo;
        } else {
            if (buscar(nodo.getEtiqueta()) == null){
                cantidadElementos++;
                ultimo.setSiguiente(nodo);
                ultimo = nodo;
            }else {
                System.out.println("No se pudo insertar el elemento " + nodo.getEtiqueta() + " ya que esta repetido\n");
            }
        }
    }


    @Override
    public void insertar(Comparable etiqueta, Object dato) {
        insertar(new Nodo<>(etiqueta, dato));
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo aux = primero;
        while (aux != null) {
            if (aux.getEtiqueta().equals(clave)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        Nodo aux = primero;
        Nodo ant = null;
        while (aux != null) {
            if (aux.getEtiqueta().equals(clave)) {
                if (ant == null) {
                    primero = aux.getSiguiente();
                } else {
                    ant.setSiguiente(aux.getSiguiente());
                }
                return true;
            }
            ant = aux;
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String str = "";
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                T dato =  aux.getDato();
                str += "Dato: " + dato.toString() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return str;
    }

    @Override
    public String imprimir(String separador) {
        return null;
    }

    @Override
    public int cantElementos() {
        return cantidadElementos;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo unNodo) {
        this.primero = unNodo;
    }
}