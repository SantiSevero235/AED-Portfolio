package uy.edu.ucu.aed.tas.ta1;

import uy.edu.ucu.aed.tdas.THash;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== PARTE 1: Prueba sin leer archivos ===");

        THash<Integer, Integer> tabla1 = new THash<>(11); // tabla pequeña para provocar colisiones

        int[] clavesInsertar = {5, 16, 27, 38, 49};  // Todas colisionan con %11 = 5
        for (int clave : clavesInsertar) {
            tabla1.insertar(clave, clave);
        }

        int[] clavesBuscarExito = {5, 16, 27};
        for (int clave : clavesBuscarExito) {
            tabla1.buscar(clave);
        }

        int[] clavesBuscarFalla = {99, 100};
        for (int clave : clavesBuscarFalla) {
            tabla1.buscar(clave);
        }

        System.out.println("Resultados de la tabla hash (prueba manual):");
        System.out.println("Promedio comparaciones inserción: " + tabla1.getPromedioComparacionesInsercion(clavesInsertar.length));
        System.out.println("Búsquedas exitosas: " + tabla1.getCantidadBusquedasExitosas());
        System.out.println("Promedio comparaciones exitosas: " + tabla1.getPromedioComparacionesBusquedaExitosa());
        System.out.println("Búsquedas infructuosas: " + tabla1.getCantidadBusquedasInfructuosas());
        System.out.println("Promedio comparaciones infructuosas: " + tabla1.getPromedioComparacionesBusquedaInfructuosa());

        /*Lectura desde archivos , hice varias pruebas y fallaban pq faltaba pasar a int, como se muestra abajo (tenerlo en cuenta) 
         * 
         *                 int clave = Integer.parseInt(linea.trim());

        */

        THash<Integer, Integer> tabla2 = new THash<>(289); //  Se elige 289 pq el factor de carga con 0.7 de 200 elementos es 286 aprox y su próximo primo es 289

        String[] archivoInsertar = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/tas/ta1/claves_insertar.txt");
        String[] archivoBuscar = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/tas/ta1/claves_buscar.txt");

        int totalInsertadas = 0;
        for (String linea : archivoInsertar) {
            try {
                int clave = Integer.parseInt(linea.trim());
                tabla2.insertar(clave, clave);
                totalInsertadas++;
            } catch (NumberFormatException e) {
                System.out.println("Línea inválida al insertar: " + linea);
            }
        }

        for (String linea : archivoBuscar) {
            try {
                int clave = Integer.parseInt(linea.trim());
                tabla2.buscar(clave);
            } catch (NumberFormatException e) {
                System.out.println("Línea inválida al buscar: " + linea);
            }
        }


        System.out.println("\n=== Resultados de la tabla hash (archivos) ===");
        System.out.println("Total claves insertadas: " + totalInsertadas);
        System.out.println("Promedio comparaciones inserción: " + tabla2.getPromedioComparacionesInsercion(totalInsertadas));
        System.out.println("Búsquedas exitosas: " + tabla2.getCantidadBusquedasExitosas());
        System.out.println("Promedio comparaciones exitosas: " + tabla2.getPromedioComparacionesBusquedaExitosa());
        System.out.println("Búsquedas infructuosas: " + tabla2.getCantidadBusquedasInfructuosas());
        System.out.println("Promedio comparaciones infructuosas: " + tabla2.getPromedioComparacionesBusquedaInfructuosa());



        /*=== Resultados de la tabla hash (archivos) ===
Total claves insertadas: 200
Promedio comparaciones inserci�n: 1.9
B�squedas exitosas: 47
Promedio comparaciones exitosas: 2.3617021276595747
B�squedas infructuosas: 153
Promedio comparaciones infructuosas: 7.875816993464053 */
    }
}
