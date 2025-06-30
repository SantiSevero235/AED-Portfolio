
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed =  (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "src/barrio.txt",
                "src/distancias.txt",
                false, TGrafoRedElectrica.class);

        TAristas a = laRed.mejorRedElectrica();
        String[] str = new String[a.size()];
        int c = 0;
        for (TArista arista : a){
            str[c] = arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto();
            c++;
        }
        ManejadorArchivosGenerico.escribirArchivo("src/redelectrica.txt",str);
    }
}
