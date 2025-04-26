package com.ut3.pd9;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Expresion expresion = new Expresion();

        // Lista de entradas con corchetes balanceados
        String[] entradasBalanceadas = {"{", "}", "{", "}", "{", "}"};
        boolean balanceados = expresion.controlCorchetes(entradasBalanceadas);
        System.out.println("Los corchetes están balanceados: " + balanceados);

        // Lista de entradas con corchetes no balanceados
        String[] entradasNoBalanceadas = {"{", "}", "{", "{"};
        boolean noBalanceados = expresion.controlCorchetes(entradasNoBalanceadas);
        System.out.println("Los corchetes están balanceados: " + noBalanceados);
    }
}
