package org.ta3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class ContadorPalabras {
    int contador = 0;
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

}
