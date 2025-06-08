package uy.edu.ucu.aed.pd3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomLinePrinter {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java -cp out uy.edu.ucu.aed.pd3.RandomLinePrinter <rutaArchivo> <numLineasAImprimir>");
            return;
        }

        String rutaArchivo = args[0];
        int numLineasAImprimir;

        try {
            numLineasAImprimir = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("El segundo parámetro debe ser un número entero.");
            return;
        }

        imprimirLineasAleatorias(rutaArchivo, numLineasAImprimir);
    }

    public static void imprimirLineasAleatorias(String rutaArchivo, int numLineasAImprimir) {
        File archivo = new File(rutaArchivo);
        long tamanioEnBytes = archivo.length();
        int estimacionLineas = (int) (tamanioEnBytes / 100L);  // Se asume promedio de 100 bytes por línea
        ArrayList<String> lineas = new ArrayList<>(estimacionLineas);

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (numLineasAImprimir > lineas.size()) {
            System.out.println("La cantidad de líneas a imprimir es mayor que las líneas en el archivo.");
            return;
        }

        Random random = new Random();
        for (int i = 0; i < numLineasAImprimir; i++) {
            int indice = random.nextInt(lineas.size());
            System.out.println(lineas.get(indice));
        }
    }
}
