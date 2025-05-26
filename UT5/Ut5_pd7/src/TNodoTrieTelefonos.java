import java.util.LinkedList;
import java.util.List;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private final static int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrieTelefonos[] hijos;
    private boolean esPalabra;
    private boolean esAbonado;
    private String telefono;
    private String nombre;

    public TNodoTrieTelefonos() {
        hijos = new TNodoTrieTelefonos[36];
        esPalabra = false;
        esAbonado = false;
        telefono = "";
        nombre = "";
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < primerosDigitos.length(); c++) {
            char ch = primerosDigitos.charAt(c);
            int indice = getIndice(ch);
            if (nodo.hijos[indice] == null) {
                return;
            }
            nodo = nodo.hijos[indice];
        }
        predecir(primerosDigitos, abonados, nodo);
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            char ch = unAbonado.getTelefono().charAt(c);
            int indice = getIndice(ch);
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.telefono = unAbonado.getTelefono();
        nodo.nombre = unAbonado.getNombre();
        nodo.esAbonado = true;
    }

    public void predecir(String s, LinkedList<TAbonado> abonados, TNodoTrieTelefonos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra && nodo.esAbonado) {
                abonados.add(new TAbonado(nodo.nombre, nodo.telefono));
            }
            for (int c = 0; c < 36; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c < CANT_CHR_ABECEDARIO  ? c + 'a' : c - 26 + '0'), abonados, nodo.hijos[c]);
                }
            }
        }
    }

    public void predecir(String prefijo, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir(prefijo, abonados, nodo);
        }
    }

    private TNodoTrieTelefonos buscarNodoTrie(String s) {
        TNodoTrieTelefonos nodo = this;
        for (int c = 0; c < s.length(); c++) {
            char ch = s.charAt(c);
            int indice = getIndice(ch);
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private int getIndice(char c) {
        if (Character.isDigit(c)) {
            return c - '0' + 26;
        } else if (Character.isLowerCase(c)) {
            return c - 'a';
        } else if (Character.isUpperCase(c)) {
            return c - 'A';
        }
        throw new IllegalArgumentException("Invalid character: " + c);
    }

    private void imprimir(String s, TNodoTrieTelefonos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                s += " ";
                if (nodo.esAbonado) {
                    s = s.trim();
                    System.out.println(nodo.nombre + ", " + nodo.telefono);
                }
            }
            for (int c = 0; c < 36; c++) {
                if (nodo.hijos[c] != null && c <= 25) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                } else {
                    imprimir(s, nodo.hijos[c]);
                }
            }
        }
    }

    public void imprimir() {
        imprimir("", this);
    }
}
