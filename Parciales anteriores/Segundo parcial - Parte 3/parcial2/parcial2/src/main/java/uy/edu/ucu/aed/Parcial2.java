package uy.edu.ucu.aed;

import java.util.LinkedList;

public class Parcial2
{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // 1 - Cargar el Grafo
        TGrafoRedDatos grafo = UtilGrafos.cargarGrafo("src/main/dispositivos.txt", "src/main/conexiones.txt", false, TGrafoRedDatos.class);

        // 2 - Verificar que los componentes se encuentren conectados
        boolean conectados = grafo.conectados("CS10","CS60");
        boolean conectados2 = grafo.conectados("CS30","CS80");
        boolean conectados3 = grafo.conectados("CS80","CS90");

        System.out.println(conectados);
        System.out.println(conectados2);
        System.out.println(conectados3);
        
        // 3 - Leer y cargar archivo mediciones.txt
        TDato[] datos = Parcial2.cargarMediciones("src/main/mediciones.txt");
        
        // 4 - Obtener dato de mayor medicion.
        TMedidor medidor = new TMedidor();
        TDato mayorMedicion = medidor.obtenerMayorMedicion(datos);

        // 5 - Emitir archivo de salida salida.txt
        LinkedList<String> lineasSalida = new LinkedList<>();

        lineasSalida.add("Conexiones:");
        lineasSalida.add("CS10 a CS60: " + conectados);
        lineasSalida.add("CS30 a CS80: " + conectados2);
        lineasSalida.add("CS80 a CS90: " + conectados3);
        lineasSalida.add("");

        if (mayorMedicion != null) {
            lineasSalida.add("Mayor medición:");
            lineasSalida.add("Valor: " + mayorMedicion.getValor());
            lineasSalida.add("Fecha: " + mayorMedicion.getFecha());
        } else {
            lineasSalida.add("No se encontraron mediciones.");
        }

        ManejadorArchivosGenerico.escribirArchivo("src/main/java/salida.txt", lineasSalida.toArray(new String[0]));
    }

    private static TDato[] cargarMediciones(String rutaAlArchivo) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaAlArchivo, false);
        
        TDato[] mediciones = new TDato[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            String[] datos = lineas[i].split(",");
            mediciones[i] = new TDato(Double.parseDouble(datos[1]), Integer.parseInt(datos[0]));
        }

        return mediciones;
    }
}
