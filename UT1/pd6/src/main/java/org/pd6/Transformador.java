package org.pd6;

import java.io.*;

public class Transformador {
    public static void transformarTextoT9(String rutaArchivo) {
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/salida.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                for (char c : linea.toCharArray()) {
                    char upperCaseC = Character.toUpperCase(c);
                    switch (upperCaseC) {
                        case 'A' :
                            bw.write("2");
                            break;
                        case 'B':
                            bw.write("22");
                            break;
                        case 'C':
                            bw.write("222");
                            break;
                        case 'D':
                            bw.write("3");
                            break;
                        case 'E':
                            bw.write("33");
                            break;
                        case 'F':
                            bw.write("333");
                            break;
                        case 'G':
                            bw.write("4");
                            break;
                        case 'H':
                            bw.write("44");
                            break;
                        case 'I':
                            bw.write("444");
                            break;
                        case 'J':
                            bw.write("5");
                            break;
                        case 'K':
                            bw.write("55");
                            break;
                        case 'L':
                            bw.write("555");
                            break;
                        case 'M':
                            bw.write("6");
                            break;
                        case 'N':
                            bw.write("66");
                            break;
                        case 'O':
                            bw.write("666");
                            break;
                        case 'P':
                            bw.write("7");
                            break;
                        case 'Q':
                            bw.write("77");
                            break;
                        case 'R':
                            bw.write("777");
                            break;
                        case 'S':
                            bw.write("7777");
                            break;
                        case 'T':
                            bw.write("8");
                            break;
                        case 'U':
                            bw.write("88");
                            break;
                        case 'V':
                            bw.write("888");
                            break;
                        case 'W':
                            bw.write("9");
                            break;
                        case 'X':
                            bw.write("99");
                            break;
                        case 'Y':
                            bw.write("999");
                            break;
                        case 'Z':
                            bw.write("9999");
                            break;
                        case ' ':
                            bw.write("0");
                            break;
                        case '.':
                            bw.write("1");
                            break;

                        default:
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Error al transformar el texto "+e.getMessage());
        }
    }

    public static void transformarT9Texto(String rutaArchivo){
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/salidaReversa.txt"))){
            String lineaReversa;

            while ((lineaReversa = br.readLine()) != null) {
                String lineaInvertida = new StringBuilder(lineaReversa).reverse().toString();

                for (char c : lineaInvertida.toCharArray()) {
                    char upperCaseC = Character.toUpperCase(c);
                    switch (upperCaseC) {
                        case 'A' :
                            bw.write("2");
                            break;
                        case 'B':
                            bw.write("22");
                            break;
                        case 'C':
                            bw.write("222");
                            break;
                        case 'D':
                            bw.write("3");
                            break;
                        case 'E':
                            bw.write("33");
                            break;
                        case 'F':
                            bw.write("333");
                            break;
                        case 'G':
                            bw.write("4");
                            break;
                        case 'H':
                            bw.write("44");
                            break;
                        case 'I':
                            bw.write("444");
                            break;
                        case 'J':
                            bw.write("5");
                            break;
                        case 'K':
                            bw.write("55");
                            break;
                        case 'L':
                            bw.write("555");
                            break;
                        case 'M':
                            bw.write("6");
                            break;
                        case 'N':
                            bw.write("66");
                            break;
                        case 'O':
                            bw.write("666");
                            break;
                        case 'P':
                            bw.write("7");
                            break;
                        case 'Q':
                            bw.write("77");
                            break;
                        case 'R':
                            bw.write("777");
                            break;
                        case 'S':
                            bw.write("7777");
                            break;
                        case 'T':
                            bw.write("8");
                            break;
                        case 'U':
                            bw.write("88");
                            break;
                        case 'V':
                            bw.write("888");
                            break;
                        case 'W':
                            bw.write("9");
                            break;
                        case 'X':
                            bw.write("99");
                            break;
                        case 'Y':
                            bw.write("999");
                            break;
                        case 'Z':
                            bw.write("9999");
                            break;
                        case ' ':
                            bw.write("0");
                            break;
                        case '.':
                            bw.write("1");
                            break;

                        default:
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Error al transformar el texto "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        transformarTextoT9("src/entradaT9.txt");
        transformarT9Texto("src/entradaT9.txt");
    }
}
