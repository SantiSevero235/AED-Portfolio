package uy.edu.ucu.aed.pd3;

public class TArbolGenerico<T> {
    private TNodoArbolGenerico<T> raiz;

    public TArbolGenerico() {
        this.raiz = null;
    }

    public TNodoArbolGenerico<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(TNodoArbolGenerico<T> raiz) {
        this.raiz = raiz;
    }

    public boolean insertar(String etiquetaNodoPadre, String etiquetaNuevoNodo) {
        if (etiquetaNodoPadre.equals("")) {
            this.raiz = new TNodoArbolGenerico<>(etiquetaNuevoNodo);
            return true;
        } else {
            TNodoArbolGenerico<T> padre = buscar(etiquetaNodoPadre);
            if (padre == null) {
                return false;
            } else {
                padre.insertar(etiquetaNuevoNodo);
                return true;
            }
        }
    }

    public TNodoArbolGenerico<T> buscar(String valorBuscado) {
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(valorBuscado);
        }
    }

    public String listarIndentado() {
        if (raiz == null) {
            return null;
        } else {
            return raiz.listarIndentado(0);
        }
    }
}
