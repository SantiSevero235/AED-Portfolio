package uy.edu.ucu.aed.TA;

import uy.edu.ucu.aed.tdas.ILista;
import uy.edu.ucu.aed.tdas.Lista;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

public class MainTA6 {

    public static void main(String[] args) {
        // Leer archivo desde la raíz del proyecto
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\entradas.txt");

        System.out.println("Archivo leído.\n");

        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i];
            ILista<Character> lista = convertirAListaDeCaracteres(linea);
            boolean resultado = ControladorDeCorchetes.validacionDeSecuencia(lista);

            if (resultado){
                System.out.println("Línea " + (i + 1) + ": " + linea + " esta " + "Bien formada");
            }else {
                System.out.println("Línea " + (i + 1) + ": " + linea + " esta " + "Mal formada");
            }
        }
    }

    public static Lista<Character> convertirAListaDeCaracteres(String texto) {
        Lista<Character> lista = new Lista<>();
        for (int i = 0; i < texto.length(); i++) {
            lista.insertar(texto.charAt(i), i);
        }
        return lista;
    }
}
