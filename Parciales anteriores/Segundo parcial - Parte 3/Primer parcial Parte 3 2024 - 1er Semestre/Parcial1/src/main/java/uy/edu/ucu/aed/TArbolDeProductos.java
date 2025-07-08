package uy.edu.ucu.aed;

public class TArbolDeProductos extends TArbolBB<Producto> {

    public int longitudTrayectoriaInterna() {
        if (this.esVacio()) {
            return 0;
        } else {
            return this.raiz.longitudTrayectoriaInterna(0);
        }
    }

    public double longitudTrayectoriaInternaMedia() {
        if (this.esVacio()) {
            return 0;
        } else {
            int lti = longitudTrayectoriaInterna();
            int cantidadNodos = this.raiz.obtenerTamaño();
            return (double) lti / cantidadNodos;
        }
    }

    public int obtenerAltura() {
        if (this.esVacio()) {
            return 0;
        } else {
            return this.raiz.obtenerAltura();
        }
    }
}
