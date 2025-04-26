package com.ut3.pd4;

public class Almacen implements IAlmacen {
    public String direccion;
    public String telefono;
    public String nombre;
    public Lista lista;

    public Almacen (String direccion, String telefono, String nombre) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        lista = new Lista();
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
        return lista;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        lista.insertar(unProducto.id, unProducto);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return lista.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return lista.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return lista.imprimir(" -> ");
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto producto = (Producto) lista.buscar(clave).getDato();
        if (producto != null) {
            producto.stock += cantidad;
            return true;
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        if (lista.buscar(clave) != null) {
            Producto producto = (Producto) lista.buscar(clave).getDato();
            producto.stock -= cantidad;
            return cantidad;
        }
        return 0;
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorCodigo'");
    }

    @Override
    public void listarOrdenadoPorNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarOrdenadoPorNombre'");
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorDescripcion'");
    }

    @Override
    public int cantidadProductos() {
        return lista.cantElementos();
    }

    public double procesarAltas(String archivoAltas) {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = manejadorArchivos.leerArchivo(archivoAltas);
    
        double valorTotalAgregado = 0.0;
    
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            String id = datos[0].trim();
            String descripcion = datos[1].trim();
            int precio = Integer.parseInt(datos[2].trim());
            int cantidad = Integer.parseInt(datos[3].trim());
    
            Nodo<Producto> nodoProducto = lista.buscar(id);
            if (nodoProducto != null) {
                Producto producto = nodoProducto.getDato();
                producto.stock += cantidad;
                valorTotalAgregado += precio * cantidad;
            } else {
                Producto nuevoProducto = new Producto(descripcion, id, precio, cantidad);
                lista.insertar(id, nuevoProducto);
                valorTotalAgregado += precio * cantidad;
            }
        }
    
        return valorTotalAgregado;
    }

    public double procesarVentas(String archivoVentas) {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = manejadorArchivos.leerArchivo(archivoVentas);
    
        double valorTotalReducido = 0.0;
    
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            String id = datos[0].trim();
            int cantidad = Integer.parseInt(datos[1].trim());
    
            Nodo<Producto> nodoProducto = lista.buscar(id);
            if (nodoProducto != null) {
                Producto producto = nodoProducto.getDato();
                int cantidadVendida = Math.min(producto.stock, cantidad);
                producto.stock -= cantidadVendida;
                valorTotalReducido += producto.precio * cantidadVendida;
            }
        }
    
        return valorTotalReducido;
    }
    
       
    
}
