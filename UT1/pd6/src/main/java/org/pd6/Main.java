package org.pd6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void imprimirTablero(int largo, int ancho) {
        for (int i = 0; i <= largo; i++) {
            for (int j = 0; j <= ancho; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void leerEntradaArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            int entero = Integer.parseInt(br.readLine());
            double flotante = Double.parseDouble(br.readLine());
            String nombre = br.readLine();


            System.out.println("El entero leido es: " + entero);
            System.out.println("El número de punto flotante es: " + flotante);
            System.out.println("La cadena leída es: " + nombre);
            System.out.println("!Hola " + nombre +"! La suma de " + entero + " y " + flotante + " es " + (entero+flotante));
            System.out.println("La división entera de " + flotante + " y " + entero + " es " + (flotante/entero) + " su resto es " + (flotante%entero)+".");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void leerEntradaStdin() {
        Scanner escaner = new Scanner(System.in);

        System.out.println("Ingrese el radio de la circunferencia: 3");

        double radio = escaner.nextDouble();
        double area = Math.PI * Math.pow(radio,2);
        double perimetro = 2 * Math.PI * radio;

        System.out.println("El area de la circunferencia con radio " + radio + " es: " + area);
        System.out.println("El perímetro de la circunferencia con radio " + radio + " es: " + perimetro);

        escaner.close();
    }

    public static void main(String[] args) {
        imprimirTablero(7,7);
        System.out.println(" ");
        leerEntradaArchivo("src/entrada.txt");
        System.out.println(" ");
        leerEntradaStdin();
    }
}