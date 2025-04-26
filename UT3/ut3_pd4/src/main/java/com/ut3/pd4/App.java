package com.ut3.pd4;

public class App {
    public static void main(String[] args) {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();

        Almacen a = new Almacen("Coronel Brandzen","092291883","Geant");
        Producto p1 = new Producto("Naranja 100g", "0001",68,25);
        Producto p2 = new Producto("Helado Crufi","0002",80,30);

        a.insertarProducto(p1);
        a.insertarProducto(p2);

        System.out.println(a.imprimirProductos());
        System.out.println("Cantidad de productos: " + a.cantidadProductos());
        System.out.println("Stock restado: " + a.restarStock("0001",10));
        a.imprimirProductos();
        System.out.println("Cantidad de productos: " + a.cantidadProductos());

        System.out.println("Stock restante: "+ p1.stock);

        System.out.println("----------------------------");
        System.out.println("----------------------------");

        Almacen almacen = new Almacen("18 de Julio", "092299854", "El Caniche");

        String[] lineas = manejadorArchivos.leerArchivo("src/altasPrueba.txt");

        for (String linea : lineas) {
            String[] datos = linea.split(",");
            // Suponiendo que los datos del archivo están en el orden: id, nombre, descripcion, stock
            String id = datos[0].trim();
            String nombre = datos[1].trim();
            int precio = Integer.parseInt(datos[2].trim());
            int stock = Integer.parseInt(datos[3].trim());

            // Crear un nuevo producto con los datos leídos
            Producto producto = new Producto(id, nombre,precio, stock);

            // Insertar el producto en el almacén
            almacen.insertarProducto(producto);
        }

        // Opcional: imprimir la lista de productos para verificar la inserción
        System.out.println("Productos en el almacén:");
        System.out.println(almacen.imprimirProductos());
        
    }
}
