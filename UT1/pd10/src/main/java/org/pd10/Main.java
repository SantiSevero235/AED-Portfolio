package org.pd10;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContadorPalabras contPalabras = new ContadorPalabras();

        String[] Ar1={"Hola", "mundo", "de", "los", "algoritmos"};
        String[] Ar2={"Hola", "mundo", "de", "la", "informática"};

        String[] arResultado = contPalabras.palabrasComunes(Ar1, Ar2);

        for(String palabra: arResultado) {
            System.out.println(palabra);
        }
    }
}
