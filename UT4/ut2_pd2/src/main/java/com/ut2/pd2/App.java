package com.ut2.pd2;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Operaciones operador = new Operaciones();
        
        System.out.println(operador.factorial(4));
        System.out.println(operador.factorial(5));
        System.out.println(operador.factorial(0));
        System.out.println();

        List<Integer> lista = new ArrayList();

        lista.add(1);
        lista.add(2);
        lista.add(3);

        System.out.println(operador.sumaLineal(lista, 2));
        System.out.println();

        System.out.println(operador.calcularPotencia(5, 2));
        System.out.println();

        ArrayList a = new ArrayList<>();
        ArrayList vacio = new ArrayList<>();
        ArrayList uno = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        uno.add(1);
        System.out.println(a);
        ArrayList invert = operador.invertirArray(a,1, 3);
        //ArrayList invert2 = Operaciones.invertirArray(a,1, 4);
        ArrayList empty = operador.invertirArray(vacio,1,1);
        ArrayList soloUno = operador.invertirArray(uno, 1, 1);
        System.out.println(invert);
        //System.out.println(invert2);
        System.out.println(empty);
        System.out.println(soloUno);
    }
}
