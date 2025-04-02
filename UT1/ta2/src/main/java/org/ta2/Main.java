package org.ta2;

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
        boolean prime = true;
        long i = 3;
        while(i < Math.sqrt(n)){
            if (n % i == 0) {
                prime = false;
                break;
            }
            i += 2;
        }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
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


    public static void main(String[] args) {
        int num = 5;
        System.out.println("El factorial de " + num + " es: " + factorial(num));
        System.out.println(" ");

        long numero = 5;

        System.out.println("Es el número " + numero + " primo? " + isPrime(numero));
        if (isPrime(numero)) {
            System.out.println("La suma de los números pares es: " + sumaPares(numero));
        } else {
            System.out.printf("La suma de los números impares es: " + sumaImpares(numero));
        }
    }
}
