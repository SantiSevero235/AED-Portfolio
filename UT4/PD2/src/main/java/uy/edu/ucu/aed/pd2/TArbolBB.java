package uy.edu.ucu.aed.pd2;

public class TArbolBB<T> implements IArbolBB<T>{
    private TElementoAB<T> raiz;

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {
            raiz = unElemento;
            return false;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        return null;
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "arbol vacío";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "arbol vacío";
        } else {
            return raiz.postOrden();

        }    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {

    }
}
