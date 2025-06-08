package uy.edu.ucu.aed.pd3;

import java.util.HashMap;

public class THash<K, V> implements IHash<K, V> {

    // Implementación de la tabla hash
    // Aquí se pueden definir los atributos necesarios, como un array de buckets, etc.


    private static class Entrada<K, V> {
        K clave;
        V valor;

  

        Entrada(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private Entrada<K, V>[] tabla;
    private int m;  // tamaño de la tabla
    private int tamanio;  // cantidad actual de elementos
    // Variables necesarias para contar comparaciones (TA1 )
    private int totalComparacionesInsercion = 0; 
    private int totalComparacionesBusquedaExitosa = 0;
    private int totalComparacionesBusquedaInfructuosa = 0;
    private int cantidadBusquedasExitosas = 0;
    private int cantidadBusquedasInfructuosas = 0;


    @SuppressWarnings("unchecked")
    public THash(int capacidad) {
        this.m = capacidad;
        this.tabla = new Entrada[m];
        this.tamanio = 0;
    }
    
        
    @Override
    public V buscar(K unaClave) {
        int comparaciones = 0;

        for (int i = 0; i < m; i++) { 
            int j = (funcionHashing(unaClave) + i) % m; // Se calcula el índice en la tabla
            comparaciones++;

            Entrada<K, V> entrada = tabla[j];

            if (entrada == null) {
                totalComparacionesBusquedaInfructuosa += comparaciones; 
                cantidadBusquedasInfructuosas++;
                return null;
            }

            if (entrada.clave.equals(unaClave)) { // Si se encuentra la clave 
                totalComparacionesBusquedaExitosa += comparaciones; // Se suman las comparaciones de búsqueda exitosa
                cantidadBusquedasExitosas++; // Y la incrementa 
                return entrada.valor;
            }
        }

        totalComparacionesBusquedaInfructuosa += comparaciones;
        cantidadBusquedasInfructuosas++;
        return null;
    }


    @Override
    public boolean insertar(K unaClave, V unValor) {
        int comparaciones = 0;

        for (int i = 0; i < m; i++) { // Se usa el método de sondeo lineal
            int j = (funcionHashing(unaClave) + i) % m;  // Se calcula el índice en la tabla
            comparaciones++;  // Se modifica tanto busqueda como insertar para que cuente las comp 

            Entrada<K, V> entrada = tabla[j]; 

            if (entrada == null) {
                tabla[j] = new Entrada<>(unaClave, unValor); 
                tamanio++;
                totalComparacionesInsercion += comparaciones; // Se suman las comparaciones de inserción
                return true;
            } else if (entrada.clave.equals(unaClave)) {
                entrada.valor = unValor;
                totalComparacionesInsercion += comparaciones;
                return true;
            }
        }

        totalComparacionesInsercion += comparaciones;
        return false;
    }


    protected int funcionHashing(K unaClave) {
        // Implementar una función de hashing adecuada para las claves
        // Por ejemplo, se puede usar el método hashCode() de la clave y aplicar un módulo con el tamaño de la tabla
        int hash = unaClave.hashCode();
        return Math.abs(hash % m); // Se agrega el abs ya que si el tamaño es 0 puede dar problemas

    }

        public double getPromedioComparacionesInsercion(int cantidadInserciones) {
        if (cantidadInserciones == 0) {
            return 0;
        } else {
            return (double) totalComparacionesInsercion / cantidadInserciones;
        }
    }

    public double getPromedioComparacionesBusquedaExitosa() {
        if (cantidadBusquedasExitosas == 0) {
            return 0;
        } else {
            return (double) totalComparacionesBusquedaExitosa / cantidadBusquedasExitosas;
        }
    }

    public double getPromedioComparacionesBusquedaInfructuosa() {
        if (cantidadBusquedasInfructuosas == 0) {
            return 0;
        } else {
            return (double) totalComparacionesBusquedaInfructuosa / cantidadBusquedasInfructuosas;
        }
    }

    public int getCantidadBusquedasExitosas() {
        return cantidadBusquedasExitosas;
    }

    public int getCantidadBusquedasInfructuosas() {
        return cantidadBusquedasInfructuosas;
    }

    public void eliminarEntradasNulas(HashMap<K, V> map) {
        map.entrySet().removeIf(e -> e.getValue() == null);
    }

    public HashMap<String, String> intercambiarCV(HashMap<K, V> map) {
        HashMap<String, String> intercambiados = new HashMap<>();
        for (HashMap.Entry<K, V> entry : map.entrySet()) {
            K clave = entry.getKey();
            V valor = entry.getValue();
            if (intercambiados.containsKey(valor)) {
                throw new RuntimeException("EXCEPCION: Se repite clave");
            }
            intercambiados.put(valor.toString(), clave.toString());
        }
        return intercambiados;
    }


}
