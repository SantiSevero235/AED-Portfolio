package uy.edu.ucu.aed;

import java.util.LinkedList;
import java.util.List;

public class Parcial2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaTransporte sistema = new SistemaTransporte();
        sistema.agregarRuta("A", "B", 5);
        sistema.agregarRuta("A", "C", 10);
        sistema.agregarRuta("B", "C", 2);
        sistema.agregarRuta("B", "D", 4);
        sistema.agregarRuta("C", "D", 1);

        StringBuilder salida = new StringBuilder();

        int tiempoMinimo = sistema.consultaTiempoMinimo("A", "D");
        if (tiempoMinimo == -1) {
            salida.append("No existe un camino entre A y D.\n");
        } else {
            salida.append("Tiempo mínimo entre A y D: ").append(tiempoMinimo).append(" minutos\n");
        }

        if (tiempoMinimo == -1) {
            System.out.println("No existe un camino entre A y D.");
        } else {
            System.out.println("Tiempo mínimo entre A y D: " + tiempoMinimo + " minutos");
        }


        List<SistemaTransporte.RutaConectada> red = sistema.redDeMantenimiento();
        salida.append("Red de mantenimiento:\n");
        System.out.println("Red de mantenimiento:");
        for (SistemaTransporte.RutaConectada ruta : red) {
            String linea = ruta.origen + " - " + ruta.destino + ": " + ruta.tiempo + " minutos\n";
            salida.append(linea);
            System.out.print(ruta.origen + " - " + ruta.destino + ": " + ruta.tiempo + " minutos\n");
        }

        // Emitir archivo de salida salida.txt
        String nombreArchivo = "salida.txt";
        ManejadorArchivosGenerico.escribirArchivo(nombreArchivo, salida.toString().split("\n"));

    }
}