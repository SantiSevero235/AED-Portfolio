package uy.edu.ucu.aed;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TClasificador {
    public static final int METODO_CLASIFICACION_INSERCION = 1; //ya esta hecha
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3; //ya esta hecha
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_HEAPSORT = 5;
    public static final int METODO_CLASIFICACION_RADIXSORT = 6;

    public static enum TipoOrden {
        DESCENDIENTE, ASCENDENTE, ALEATORIO
    }

    /**
     *
     * @param datosParaClasificar
     * @param metodoClasificacion
     * @return
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_RADIXSORT:
                return ordenarPorRadixSort(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }

    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        // TODO:Implementar encuentraPivote a criterio de cada equipo
        int posicionPivote = encuentraPivote(izquierda, derecha, entrada);

        while (izquierda <= derecha) {
            while ((entrada[izquierda] < posicionPivote)) {
                izquierda++;
            }

            while ((posicionPivote < entrada[derecha])) {
                derecha--;
            }

            if (izquierda <= derecha) {
                intercambiar(entrada, derecha, izquierda);
                izquierda++;
                derecha--;
            }
        }

        if (i < derecha){
            quicksort(entrada, i, derecha);
        }
        if (izquierda < j){
            quicksort(entrada, izquierda, j);
        }
    }

    private int encuentraPivote(int izquierda, int derecha, int[] entrada) {

        int medio = (izquierda + derecha) / 2;
        if (entrada[izquierda] > entrada[medio]){
             intercambiar(entrada, izquierda, medio);
        }
        if (entrada[izquierda] > entrada[derecha]){
             intercambiar(entrada, izquierda, derecha);
        }
        if (entrada[medio] > entrada[derecha]){
             intercambiar(entrada, medio, derecha);
        }
        return entrada[medio];
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        // Verifico si el array es null
        if (datosParaClasificar == null) {
            return null;
        }
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while (j >= 0) {
                        if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                            j -= inc;
                        } else {
                            break;  // Salgo del while si no hay intercambio
                        }
                    }
                }
            }
        }
        return datosParaClasificar;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j, j + 1);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        if (datosParaClasificar == null) {
            return null;
        }
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        if (datosParaClasificar == null) {
            return null;
        }

        int n = datosParaClasificar.length;

        // Se construye el heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            armaHeap(datosParaClasificar, n, i);
        }

        // Extrae los elementos del heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i); // Se mueve la raíz al final
            armaHeap(datosParaClasificar, i, 0);     // Se reajusta el heap
        }

        return datosParaClasificar;
    }

    private void armaHeap(int[] datos, int n, int i) {
        int mayor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        if (izquierda < n && datos[izquierda] > datos[mayor]) {
            mayor = izquierda;
        }

        if (derecha < n && datos[derecha] > datos[mayor]) {
            mayor = derecha;
        }

        if (mayor != i) {
            intercambiar(datos, i, mayor);
            armaHeap(datos, n, mayor);
        }
    }

    protected int[] ordenarPorRadixSort(int[] datosParaClasificar) {
        if (datosParaClasificar == null) return null;

        int negativosCount = 0, positivosCount = 0;
        for (int num : datosParaClasificar) {
            if (num < 0) negativosCount++;
            else positivosCount++;
        }

        int[] negativos = new int[negativosCount];
        int[] positivos = new int[positivosCount];
        int negIdx = 0, posIdx = 0;
        for (int num : datosParaClasificar) {
            if (num < 0) negativos[negIdx++] = -num;
            else positivos[posIdx++] = num;
        }

        radixSort(negativos);
        radixSort(positivos);

        int[] resultado = new int[datosParaClasificar.length];
        int idx = 0;
        for (int i = negativos.length - 1; i >= 0; i--) resultado[idx++] = -negativos[i];
        for (int i = 0; i < positivos.length; i++) resultado[idx++] = positivos[i];

        return resultado;
    }

    private void radixSort(int[] datos) {
        if (datos.length == 0) {
            return;
        }
        int max = obtenerMaximo(datos);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortPorDigito(datos, exp);
        }
    }

    private int obtenerMaximo(int[] datos) {
        int max = datos[0];
        for (int i = 1; i < datos.length; i++) {
            if (datos[i] > max) max = datos[i];
        }
        return max;
    }

    private void countingSortPorDigito(int[] datos, int exp) {
        int n = datos.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        for (int i = 0; i < n; i++) {
            conteo[(datos[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digito = (datos[i] / exp) % 10;
            salida[conteo[digito] - 1] = datos[i];
            conteo[digito]--;
        }
        System.arraycopy(salida, 0, datos, 0, n);
    }


    public double medirTiempo(int tamanioDeDatos, int metodoClasificacion, TipoOrden tipoOrden) {
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] data;
        switch (tipoOrden) {
            case DESCENDIENTE:
                data = gdg.generarDatosDescendentes(tamanioDeDatos);
                break;
            case ASCENDENTE:
                data = gdg.generarDatosAscendentes(tamanioDeDatos);
                break;
            default:
                data = gdg.generarDatosAleatorios(tamanioDeDatos);
                break;
        }
        long t1 = System.nanoTime();
        long total = 0;
        long cantLlamadas = 0;
        int tiempoResolucion = 1;

        while (total < tiempoResolucion) {
            cantLlamadas += 1;
            int[] datosCopia = Arrays.copyOf(data, tamanioDeDatos);
            clasificar(datosCopia, metodoClasificacion);
            long t2 = System.nanoTime();
            total = t2 - t1;
        }

        double tiempoMedioAlgoritmoBase = total / (double) cantLlamadas;

        t1 = System.nanoTime();
        total = 0;
        cantLlamadas = 0;
        while (total < tiempoResolucion) {
            cantLlamadas += 1;
            int[] datosCopia = Arrays.copyOf(data, tamanioDeDatos);
            clasificar(datosCopia, -1);
            long t2 = System.nanoTime();
            total = t2 - t1;
        }
        double tiempoMedioCascara = total / (double) cantLlamadas;
        // nanoseconds
        return tiempoMedioAlgoritmoBase - tiempoMedioCascara;
    }

    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        // PRUEBAS DE MEDICIÓN
        System.out.println(
                clasif.medirTiempo(100, METODO_CLASIFICACION_INSERCION, TipoOrden.ALEATORIO)
        );

        // PRUEBAS BÁSICAS
//        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
//        int[] vectorAleatorio = gdg.generarDatosAleatorios(10);
//        int[] vectorAscendente = gdg.generarDatosAscendentes(10);
//        int[] vectorDescendente = gdg.generarDatosDescendentes(10);
//
//        int[] resAleatorio = clasif.clasificar(vectorAleatorio,
//                METODO_CLASIFICACION_INSERCION);
//        for (int i = 0; i < resAleatorio.length; i++) {
//            System.out.print(resAleatorio[i] + " ");
//        }
//        int[] resAscendente = clasif.clasificar(vectorAscendente,
//                METODO_CLASIFICACION_INSERCION);
//        for (int i = 0; i < resAscendente.length; i++) {
//            System.out.print(resAscendente[i] + " ");
//        }
//        int[] resDescendente = clasif.clasificar(vectorDescendente,
//                METODO_CLASIFICACION_INSERCION);
//        for (int i = 0; i < resDescendente.length; i++) {
//            System.out.print(resDescendente[i] + " ");
//        }
    }
}
