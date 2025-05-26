import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/abonados.txt");
        for (String linea : lineas) {
            String[] unAbonado = linea.split(",");
            TAbonado nodoAbonado = new TAbonado(unAbonado[1], unAbonado[0]);
            trieAbonados.insertar(nodoAbonado);
        }


        String codigoPais = "598" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "93" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);

        String[] salida = new String[ab.size()];
        int pos = 0;
        for (TAbonado a : ab){
            String nombre = a.getNombre();
            String telefono = a.getTelefono();
            salida[pos] = telefono + ", " + nombre;
            pos++;
        }
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", salida);

        trieAbonados.imprimir();



    }
}