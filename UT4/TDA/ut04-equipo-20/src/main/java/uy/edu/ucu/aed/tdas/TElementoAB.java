package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {
    protected Comparable etiqueta;
    protected T dato;
    protected IElementoAB<T> hijoIzq;
    protected IElementoAB<T> hijoDer;
    private IElementoAB<T> padre;

    public TElementoAB(Comparable unaEtiqueta, T unDato) {
        this.etiqueta = unaEtiqueta;
        this.dato = unDato;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.padre = null;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public IElementoAB getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(this.etiqueta) < 0 && hijoIzq != null) {
            return hijoIzq.buscar(unaEtiqueta);
        } else if (hijoDer != null) {
            return hijoDer.buscar(unaEtiqueta);
        }
        return null;
    }
    
    @Override
    public boolean insertar(IElementoAB<T> elemento) {
        if (elemento.getEtiqueta().equals(this.etiqueta)) {
            return false; // Ya existe un elemento con la misma etiqueta
        } else if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            } else {
                return hijoIzq.insertar(elemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            } else {
                return hijoDer.insertar(elemento);
            }
        }
    }

    @Override
    public void preOrden(LinkedList<T> unaLista){
        unaLista.add(this.dato);
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }
    }

    @Override
    public void inOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.dato);
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    @Override
    public void postOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }
        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.dato);
    }

    @Override
    public T getDatos() {
        return dato;
    }

    @Override
    public IElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {

            // Caso 1: Nodo sin hijos
            if (hijoIzq == null && hijoDer == null) {
                return null; // El nodo se elimina devolviendo null
            }

            // Caso 2: Nodo con un solo hijo
            if (hijoIzq == null) {
                return hijoDer; // Se reemplaza por el hijo derecho
            }
            if (hijoDer == null) {
                return hijoIzq; // Se reemplaza por el hijo izquierdo
            }

            // Caso 3: Nodo con dos hijos
            // Reemplazar el nodo actual con el sucesor (mayor del subárbol izquierdo)
            IElementoAB<T> sucesor = obtenerMayor(hijoIzq);
            this.etiqueta = sucesor.getEtiqueta();
            this.dato = sucesor.getDatos();
            // Eliminar el sucesor del subárbol izquierdo
            hijoIzq = hijoIzq.eliminar(sucesor.getEtiqueta());
            return this; //Devolvemos el nodo actual modificado. NO el eliminado
        }
    
        // Si la etiqueta es menor, buscar en el subárbol izquierdo
        if (unaEtiqueta.compareTo(this.etiqueta) < 0 && hijoIzq != null) {
            //Actualizamos la referencia del nodo padre al nodo eliminado, lo hacemos de manera recursiva
            hijoIzq = hijoIzq.eliminar(unaEtiqueta);
        }

        // Si la etiqueta es mayor, buscar en el subárbol derecho
        else if (hijoDer != null) {
            hijoDer = hijoDer.eliminar(unaEtiqueta);
        }
        return this; // Retornar el nodo actual
    }
    
    private IElementoAB<T> obtenerMayor(IElementoAB<T> nodo) {
        while (nodo.getHijoDer() != null) {
            nodo = nodo.getHijoDer();
        }
        return nodo;
    }
    @Override
    public int obtenerTamaño() {
        int size = 1; // Contamos el nodo actual
        if (hijoIzq != null) {
            size += hijoIzq.obtenerTamaño();
        }
        if (hijoDer != null) {
            size += hijoDer.obtenerTamaño();
        }
        return size;
    }
}