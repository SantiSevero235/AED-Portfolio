package org.pd5;

public class ValueOfDemo {
    public static void main(String[] args) {
        // Verificar que se pasaron exactamente 2 argumentos
        if (args.length != 2) {
            System.out.println("Error: Este programa requiere exactamente dos números enteros positivos como argumentos.");
            return;
        }

        try {
            // Convertir argumentos a enteros
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            // Verificar que los números sean positivos
            if (a <= 0 || b <= 0) {
                System.out.println("Error: Ambos números deben ser enteros positivos mayores que 0.");
                return;
            }

            // Operaciones aritméticas
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa solo números enteros positivos.");
        }
    }
}
