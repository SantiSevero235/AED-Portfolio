public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        return false;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        return null;
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
    public void eliminar(Comparable unaEtiqueta) {

    }
}
