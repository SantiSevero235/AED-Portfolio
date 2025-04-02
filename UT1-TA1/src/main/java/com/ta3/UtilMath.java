package com.ta3;

public class UtilMath {
    public static int factorial(int num) {
        int result = 1;

        for (int i = num; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

}
