package org.ut3.pd6;

import org.ut3.pd6.utils.ManejadorArchivosGenerico;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lista<String> sucursales = new Lista<>();
        String[] listaSucursales1 = ManejadorArchivosGenerico.leerArchivo("src/suc1.txt");

        for (String suc : listaSucursales1) {
            sucursales.insertar(suc, suc);
        }

        Lista<String> sucursales2 = new Lista<>();
        String[] listaSucursales2 = ManejadorArchivosGenerico.leerArchivo("src/suc2.txt");

        for (String suc2 : listaSucursales2) {
            sucursales2.insertar(suc2, suc2);
        }

        System.out.println("1) Emitiendo por consola la cantidad de elementos y la lista de ciudades contenida en la estructura. La cantidad de elementos es: " + sucursales.cantElementos());
        System.out.println(sucursales.imprimir());
        System.out.println();
        sucursales.eliminar("Chicago");

        System.out.println("2) Dada la ciudad ·“Hong Kong”, la que le sigue en la lista es la ciudad ….\n c) Shenzhen\n" + sucursales.imprimir());
        System.out.println();

        System.out.println(sucursales2.imprimir());
        sucursales2.eliminar("Tokio");

        System.out.println("3. Levantar un segundo archivo, “suc2.txt”. Eliminar las ciudades “Shenzen” y “Tokio”. Se cumple lo siguiente:\n" +
                "c) Queda vacía y da error de ejecución\n" + sucursales2.imprimir());
        System.out.println();

        Lista<String> sucursales3 = new Lista<>();
        String[] listaSucursales3 = ManejadorArchivosGenerico.leerArchivo("src/suc3.txt");

        for (String suc3 : listaSucursales3) {
            sucursales3.insertar(suc3, suc3);
        }

        System.out.println("3) El resultado de esta operación es:\n "+ sucursales3.imprimir(";_"));

    }
}