public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return 
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }


    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return null;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return null;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {

    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        return null;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        return false;
    }

    @Override
    public String preOrden() {
        return "";
    }

    @Override
    public String inOrden() {
        return "";
    }

    @Override
    public String postOrden() {
        return "";
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
