package org.pd10;

import java.util.ArrayList;

public class ContadorPalabras {
    char[] vocales = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    int contVocales = 0;
    int contConsonantes = 0;

    public int contarPalabras(String frase) {
        int contador = 0;
        boolean hasLetter = false;
        for (char p : frase.toCharArray()) {
            if (Character.isLetter(p)) {
                hasLetter = true;
            } else if (Character.isWhitespace(p) && hasLetter) {
                contador++;
                hasLetter = false;
            }
        }

        if (hasLetter) {
            contador++;
        }

        return contador;
    }

    public int[] contarVocalCons(String frase) {
        for (char p : frase.toCharArray()) {
            if (Character.isLetter(p)) {
                if (esVocal(p)) {
                    contVocales += 1;
                } else {
                    contConsonantes += 1;
                }
            }
        }
        int[] contadores = {contConsonantes, contVocales};
        return contadores;
    }

    private boolean esVocal(Character a) {
        boolean isVowel = false;
        for (int i = 0; i <= 9; i++) {
            if (a.equals(vocales[i])) {
                isVowel = true;
                break;
            }
        }
        return isVowel;
    }

    public String[] obtenerLineas(String archivo) {

        return new String[0];
    }

    public int cantPalabras(String[] lineasArchivo) {
        return 0;
    }

    public String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        ArrayList<String> arResultado = new ArrayList<>();

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
}
