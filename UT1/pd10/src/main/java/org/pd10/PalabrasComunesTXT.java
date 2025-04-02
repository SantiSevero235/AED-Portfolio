package org.pd10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PalabrasComunesTXT {
    public static String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        List<String> arResultado = new ArrayList<>();

        for (String palabra1 : palabras1) {
            for (String palabra2 : palabras2) {
                if (palabra1.equals(palabra2)) {
                    arResultado.add(palabra1);
                    break;
                }
            }
        }
        return arResultado.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String rutaArchivo = "src/entrada.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea1 = br.readLine();
            String linea2 = br.readLine();

            String[] palabras1 = linea1.split(" ");
            String[] palabras2 = linea2.split(" ");

            String[] resultado = PalabrasComunesTXT.palabrasComunes(palabras1, palabras2);

            System.out.println("Palabras Comunes: ");
            for (String palabra : resultado) {
                System.out.println(palabra);
            }

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}