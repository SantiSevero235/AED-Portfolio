package uy.edu.ucu.aed.TA;

import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

public class MainTA10 {
    public static void main(String[] args) {
        System.out.println("----- 1) Leer suc1.txt -----");
        String[] ciudades1 = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\suc1.txt");
        DirectorioSucursales directorio = new DirectorioSucursales();
        directorio.cargarDesdeArchivo(ciudades1);

        System.out.println("Cantidad de sucursales: " + directorio.cantidadSucursales());
        directorio.listarSucursales();
        System.out.println();
        directorio.agregarSucursal("Montevideo");
        System.out.println(directorio.cantidadSucursales());
        System.out.println(directorio.buscarSucursal("Montevideo"));
        System.out.println(directorio.esVacia());

        System.out.println("\n----- 2) Eliminar 'Chicago' y buscar ciudad siguiente a 'Hong Kong' -----");
        directorio.quitarSucursal("Chicago");
        directorio.listarSucursales();

        String siguiente = directorio.ciudadSiguienteA("Hong Kong");
        if (siguiente != null) {
            System.out.println("La ciudad que sigue a 'Hong Kong' es: " + siguiente);
        } else {
            System.out.println("No se encontró la ciudad 'Hong Kong' o no tiene ciudad siguiente.");
        }

        System.out.println("\n----- 3): Leer suc2.txt, eliminar 'Shenzhen' y 'Tokio' -----");
        String[] ciudades2 = ManejadorArchivosGenerico.leerArchivo("src/main/java/resources/suc2.txt");
        DirectorioSucursales directorio2 = new DirectorioSucursales();
        directorio2.cargarDesdeArchivo(ciudades2);

        directorio2.quitarSucursal("Shenzhen");
        directorio2.quitarSucursal("Tokio");

        directorio2.listarSucursales();
        System.out.println("Cantidad de sucursales restantes en suc2.txt: " + directorio2.cantidadSucursales());

        System.out.println("\n----- 4) Leer suc3.txt e imprimir con separador ';_' -----");
        String[] ciudades3 = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\suc3.txt");
        DirectorioSucursales directorio3 = new DirectorioSucursales();
        directorio3.cargarDesdeArchivo(ciudades3);

        directorio3.imprimirConDelimitador(";_");
    }
}
