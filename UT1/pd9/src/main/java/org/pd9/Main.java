package org.pd9;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int factorial(int num) {
        int result = 1;
        for (int i = num; i > 1; i--) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }

        long i = 2;
        while (i * i <= n) {
            if (n % i == 0 ) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static long sumaPares(long num) {
        long suma = 0;
        long i = 0;

        while (i <= num) {
            suma += i;
            i += 2;
        }
        return suma;
    }

    public static long sumaImpares(long num) {
        long suma = 0;
        long i = 1;

        while (i <= num) {
            suma += i;
            i += 2;
        }
        return suma;
    }

    public static boolean validarPrimo(long num) {
        if(isPrime(num)){
            System.out.println("El número " + num + " es primo.");
            System.out.println("La suma de los números pares es: " + sumaPares(num));
            return true;
        } else {
            System.out.println("El número " + num + " no es primo.");
            System.out.println("La suma de los números impares es: " + sumaImpares(num));
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(" ");
        long numNoPrimo = 12 ;
        long numPrimo = 23;

        validarPrimo(numNoPrimo);
        validarPrimo(numPrimo);
    }
}