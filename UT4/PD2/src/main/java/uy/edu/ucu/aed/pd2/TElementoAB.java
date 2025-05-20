package uy.edu.ucu.aed.pd2;

public class TElementoAB<T> implements IElementoAB<T> {
    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return this;
        } else {
            if (unaEtiqueta.compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    return hijoIzq.buscar(unaEtiqueta);
                } else {
                    return null;
                }
            } else {
                if (unaEtiqueta.compareTo(etiqueta) > 0) {
                    if (hijoDer != null) {
                        return hijoDer.buscar(unaEtiqueta);
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (etiqueta.compareTo(elemento.getEtiqueta()) == 0) {
            return false;
        } else if (etiqueta.compareTo(elemento.getEtiqueta()) > 0) {
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
    public String preOrden() {
        String tempStr = this.etiqueta + " ";

        if (hijoIzq != null) {
            tempStr += hijoIzq.preOrden();
        }

        if (hijoDer != null) {
            tempStr += hijoDer.preOrden();
        }

        return tempStr;
    }

    @Override
    public String inOrden() {
        String tempStr = "";

        if (hijoIzq != null) {
            tempStr += hijoIzq.inOrden();
        }

        tempStr += this.etiqueta + " ";

        if (hijoDer != null) {
            tempStr += hijoDer.inOrden();
        }

        return tempStr;
    }

    @Override
    public String postOrden() {
        String tempStr = "";

        if (hijoIzq != null) {
            tempStr += hijoIzq.postOrden();
        }

        if (hijoDer != null) {
            tempStr += hijoDer.postOrden();
        }

        tempStr += this.etiqueta + " ";

        return tempStr;
    }


    @Override
    public T getDatos() {
        return null;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        return null;
    }
}
