package org.pd5;

public class ContadorPalabras {
    public enum vocales {
        A,E,I,O,U
    }
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
        int[] contadores = {contConsonantes,contVocales};
        return contadores;
    }

    private boolean esVocal(Character a) {
        for (vocales v : vocales.values()) {
            if (v.name().equalsIgnoreCase(String.valueOf(a))) {
                return true;
            }
        }
        return false;
    }
}