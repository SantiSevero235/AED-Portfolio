package uy.edu.ucu.aed.tdas;


public class PilaConReferencia<T> extends Lista<T> implements IPila<T>{



    public PilaConReferencia(){
        this.primero = null;
    }

    @Override
    public void apilar(T dato){
        if (dato == null) {
            //Lanzamos esta excpecion debido al Argumento invalido
            throw new IllegalArgumentException("No se puede apilar un dato que es null.");
        }
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(primero);
        primero = nuevoNodo;
    }

    @Override
    public void desapilar(){
        if (primero == null){
            //Lanzamos esta excepcion ya que el estado de la pila no permite correr el metodo
            throw new IllegalStateException("No se puede desapilar una pila ya vacia");
        }else{
            primero = primero.getSiguiente();
        }
    }

    @Override
    public T tope(){
        if (primero != null){
            return primero.getDato();
        }
        return null;
    }

    @Override
    public void anular(){
        primero = null;
    }

}