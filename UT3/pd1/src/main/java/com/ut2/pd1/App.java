package com.ut2.pd1;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void miFuncion(int N, int[] arreglo) {
        int contador = 0;
    
        for (int i = 1; i < N; i++) {  // i = 1 hasta N-1
            for (int j = N - 1; j >= i; j--) {  // j = N hasta i+1 (en reversa)
                if (arreglo[j] < arreglo[j - 1]) {
                    contador++;
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j - 1];
                    arreglo[j - 1] = temp;
                }
            }
        }
        System.out.println("Número de veces que se invocó la sentencia 'si': " + contador);
        System.out.println("Largo: " + arreglo.length);
        System.out.println("Primer elemento: " + arreglo[0]);
        System.out.println("Ultimo elemento: " + arreglo[N - 1]);
    }
    
    public static void main( String[] args )
    {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] archivo = manejadorArchivos.leerArchivo("src/numeros.txt");

        int num = Integer.parseInt(archivo[0]);
        int[] numeros = new int[num];
        for (int i = 0; i < num; i++) {
            numeros[i] = Integer.parseInt(archivo[i + 1]);
        }

        miFuncion(num, numeros);

        
    }
}
