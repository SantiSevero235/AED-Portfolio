package uy.edu.ucu.aed.TA;

import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;


public class MainTA2 {

    public static void main(String[] args) {
        Almacen almacen = new Almacen("G.E.AN.T", "Nuevocentro Shopping", "2200 7623");


        String[] lineasAltas = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\altas.txt");
        float totalComprado = procesarAltas(almacen, lineasAltas);
        System.out.println("Total invertido en compras: $" + totalComprado);


        String[] lineasVentas = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\ventas.txt");
        float totalVendido = procesarVentas(almacen, lineasVentas);
        System.out.println("Total recaudado en ventas: $" + totalVendido);

        // listar el stock
        System.out.println("\n Productos actuales en stock:");
        System.out.println(almacen.imprimirProductos());

        System.out.println(almacen.buscarPorDescripcion("YOGUR DIETETICO BIOTOP FRUTILLA"));



        // se redujeron los archivos para probar las funcionalidades en detalle
        Almacen almacenPrueba = new Almacen("PruebaGEant", "as", "0040 2000");

        System.out.println("\n===== CARGA DE PRUEBA DESDE stockPruebas.txt =====");
        String[] lineasStockPrueba = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\stockPruebas.txt");
        float totalCompradoPrueba = procesarAltas(almacenPrueba, lineasStockPrueba);
        System.out.println("Total prueba invertido: $" + totalCompradoPrueba);

        String[] lineasVentasPrueba = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\ventasPruebas.txt");
        float totalVendidoPrueba = procesarVentas(almacenPrueba, lineasVentasPrueba);
        System.out.println("Total prueba recaudado: $" + totalVendidoPrueba);

        System.out.println("Stock actualizado en almacén de prueba:");
        System.out.println(almacenPrueba.imprimirProductos());
        System.out.println(almacenPrueba.buscarPorDescripcion("ADES� DURAZNO�"));
    }

    private static float procesarAltas(Almacen almacen, String[] lineas) {
        float total = 0;
        for (String linea : lineas) {

            String[] partes = linea.split(","); // CODIGO,NOMBRE,PRECIO,CANTIDAD
            if (partes.length != 4) continue; // es como una validacion para que no haya stock mal ingresado

            String codigo = partes[0].trim();
            String nombre = partes[1].trim();
            int precio = Integer.parseInt(partes[2].trim());
            int cantidad = Integer.parseInt(partes[3].trim());

            Producto productoExistente = almacen.buscarPorCodigo(codigo);

            if (productoExistente != null) {
                almacen.agregarStock(codigo, cantidad);
            } else {
                Producto nuevo = new Producto(codigo, nombre, precio, cantidad); 
                almacen.insertarProducto(nuevo);
            }

            total += precio * cantidad;
        }
        return total;
    }

    private static float procesarVentas(Almacen almacen, String[] lineas) {
        float total = 0;
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length != 2) continue;

            String codigo = partes[0].trim();
            int cantidad = Integer.parseInt(partes[1].trim());

            Producto producto = almacen.buscarPorCodigo(codigo);
            if (producto != null) {
                int vendido = almacen.restarStock(codigo, cantidad);
                total += vendido * producto.getPrecio();
            }
        }
        return total;
    }
}

