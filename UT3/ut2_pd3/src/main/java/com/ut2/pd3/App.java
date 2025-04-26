package com.ut2.pd3;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int suma = 0;
        int n = 10;

        // Fragmento #1
        for (int i = 0; i < n; i++)
            suma++;
        System.out.println(suma);
        // Fragmento #2
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                suma++;
        System.out.println(suma);
        // Fragmento #3
        for (int i = 0; i < n; i++)
            suma++;
        System.out.println(suma);
        for (int j = 0; j < n; j++)
            suma++;
        System.out.println(suma);
        // Fragmento #4
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n*n; j++)
                suma++;
        System.out.println(suma);

        // Fragmento #5
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                suma++;
        System.out.println(suma);
        // Fragmento #6
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n*n; j++)
                for (int k = 0; k < j; k++)
                    suma++;
        System.out.println(suma);

        // Fragmento 5.15
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i*i; j++)
                if (j%i == 0)
                    for (int k = 0; k < j; k++)
                        suma++;
        System.out.println(suma);



    }
}
