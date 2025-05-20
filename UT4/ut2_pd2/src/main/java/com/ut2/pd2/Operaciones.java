package com.ut2.pd2;

import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    public static int factorial (int n) {
        if (n == 1 || n == 0) {
            return 1;
        } 
        else {
            return n * factorial(n - 1);
        }
    }

    public static int sumaLineal (List<Integer> A, int n) {
        if (n == 1) {
            return A.get(0);
        } else {
            return sumaLineal(A, n - 1) + A.get(n - 1);
        }
    }

    public static int calcularPotencia (int n, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return n;
        } else {
            return n * calcularPotencia (n, exp - 1);
        }
    }

    public static ArrayList invertirArray (ArrayList A, int i, int j) {
        if (i >= j) {
            return A;
        }
        else {
            Object temp = A.get (i - 1);
            A.set(i - 1, A.get(j - 1));
            A.set(j - 1, temp);
            return invertirArray(A, i + 1, j - 1);
        }
    }
}
