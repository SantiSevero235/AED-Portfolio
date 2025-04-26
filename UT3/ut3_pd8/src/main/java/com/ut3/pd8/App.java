package com.ut3.pd8;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ManejadorArchivosGenerico archivo = new ManejadorArchivosGenerico();
        listaSucursal ListaSucursal = new listaSucursal();
        String path = "src/suc1.txt";

        // Leer las sucursales desde el archivo y agregarlas a la lista
        String[] sucursalesArray = archivo.leerArchivo(path);
        for (String sucursal : sucursalesArray) {
            ListaSucursal.agregarSucursal(new Sucursales(sucursal));
        }

        // Listar todas las sucursales
        System.out.println("Lista de Sucursales:");
        ListaSucursal.listarSucursales();

        // Buscar una sucursal
        String ciudadABuscar = "Montevideo";
        System.out.println("\nBuscando la sucursal en la ciudad: " + ciudadABuscar);
        ListaSucursal.buscarSucursal(ListaSucursal.lista, ciudadABuscar);

        // Quitar una sucursal
        String ciudadAQuitar = "Shanghai";
        System.out.println("\nQuitando la sucursal en la ciudad: " + ciudadAQuitar);
        ListaSucursal.quitarSucursal(ciudadAQuitar);

        // Listar todas las sucursales después de quitar
        System.out.println("\nLista de Sucursales después de quitar:");
        ListaSucursal.listarSucursales();

        // Mostrar la cantidad de sucursales
        System.out.println("\nCantidad de sucursales:");
        int cantidad = ListaSucursal.cantSucursales();
        System.out.println(cantidad);

        // Verificar si la lista está vacía
        System.out.println("\n¿La lista está vacía?");
        boolean estaVacio = ListaSucursal.estaVacio();
        System.out.println(estaVacio);
    }
}
