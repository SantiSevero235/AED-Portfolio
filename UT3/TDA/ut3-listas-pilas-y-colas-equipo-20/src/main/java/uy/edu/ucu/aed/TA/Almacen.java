package uy.edu.ucu.aed.TA;

import uy.edu.ucu.aed.tdas.Lista;

public class Almacen extends Lista<Producto> implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;
    private Lista<Producto> listaProductos;

    public Almacen(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProductos = new Lista<>();
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista getListaProductos() {
        return listaProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        if (listaProductos.buscar(unProducto.getEtiqueta()) == null) {
            listaProductos.insertar(unProducto, unProducto.getEtiqueta());
        }
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto p = listaProductos.buscar(clave);
        if (p != null) {
            p.setStock(p.getStock() + cantidad);
            return true;
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto p = listaProductos.buscar(clave);
        if (p != null) {
            int stockActual = p.getStock();
            int vendido = Math.min(stockActual, cantidad);
            p.setStock(stockActual - vendido);
            return vendido;
        }
        return 0;
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        return listaProductos.buscar(clave);
    }

    @Override
    public void listarOrdenadoPorNombre() {

        System.out.println(listaProductos.imprimir("\n"));
    }

@Override
public Producto buscarPorDescripcion(String descripcion) {
    Lista<Producto>.Nodo actual = listaProductos.getPrimero();
    // agarra el primero

    while (actual != null) {
        if (actual.getDato().getNombre().equalsIgnoreCase(descripcion)) {
            return actual.getDato(); // lo encuentra
        }
        actual = actual.getSiguiente(); // acanza al sigueinte
    }

    return null; // si no se encontró
}

    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }
}