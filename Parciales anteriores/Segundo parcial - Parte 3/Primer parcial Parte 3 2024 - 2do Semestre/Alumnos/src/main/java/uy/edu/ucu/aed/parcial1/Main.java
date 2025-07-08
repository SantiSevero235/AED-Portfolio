package uy.edu.ucu.aed.parcial1;

import uy.edu.ucu.aed.tdas.TElementoAB;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        Persona juan = new Persona("Juan");
        Persona pedro = new Persona("Pedro");
        Persona marta = new Persona("Marta");
        Persona jose = new Persona("José");
        Persona ana = new Persona("Ana");
        Persona luis = new Persona("Luis");
        Persona clara = new Persona("Clara");

        TElementoAB<Persona> arbol = new TElementoAB<>(juan.getNombre(), juan);

        TElementoAB<Persona> nodoPedro = new TElementoAB<>(pedro.getNombre(), pedro);
        TElementoAB<Persona> nodoMarta = new TElementoAB<>(marta.getNombre(), marta);
        arbol.setHijoIzq(nodoPedro);
        arbol.setHijoDer(nodoMarta);

        TElementoAB<Persona> nodoJose = new TElementoAB<>(jose.getNombre(), jose);
        TElementoAB<Persona> nodoAna = new TElementoAB<>(ana.getNombre(), ana);
        nodoPedro.setHijoIzq(nodoJose);
        nodoPedro.setHijoDer(nodoAna);

        TElementoAB<Persona> nodoLuis = new TElementoAB<>(luis.getNombre(), luis);
        TElementoAB<Persona> nodoClara = new TElementoAB<>(clara.getNombre(), clara);
        nodoMarta.setHijoIzq(nodoLuis);
        nodoMarta.setHijoDer(nodoClara);

        // Parentesco entre Juan y Ana
        ResultadoParentesco resultado1 = Genealogia.calcularParentesco(arbol, arbol, nodoAna);

        // Parentesco entre Juan y una persona que no pusimos en el árbol
        Persona personaNoExistente = new Persona("Persona No Existente");
        TElementoAB<Persona> nodoNoExistente = new TElementoAB<>(personaNoExistente.getNombre(), personaNoExistente);
        ResultadoParentesco resultado2 = Genealogia.calcularParentesco(arbol, arbol, nodoNoExistente);

        // Parentesco entre José y Marta
        ResultadoParentesco resultado3 = Genealogia.calcularParentesco(arbol, nodoJose, nodoMarta);

        // Emitir archivo de salida
        emitirArchivoResultados("Resultados.txt", resultado1, resultado2, resultado3);
    }

    /**
     * Emite un archivo con los resultados de los cálculos de parentesco.
     *
     * @param nombreArchivo Nombre del archivo de salida.
     * @param resultados    Resultados de los cálculos de parentesco.
     */
    public static void emitirArchivoResultados(String nombreArchivo, ResultadoParentesco... resultados) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (int i = 0; i < resultados.length; i++) {
                printWriter.println("Resultado " + (i + 1) + ": " + resultados[i]);
            }
            System.out.println("Archivo de resultados generado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
