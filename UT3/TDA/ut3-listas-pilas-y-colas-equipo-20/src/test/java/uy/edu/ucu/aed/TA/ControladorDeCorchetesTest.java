package uy.edu.ucu.aed.TA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uy.edu.ucu.aed.tdas.ILista;
import uy.edu.ucu.aed.tdas.Lista;

public class ControladorDeCorchetesTest {

    //Mismo metodo utilizado en el mainTA6
    public static Lista<Character> convertirAListaDeCaracteres(String texto) {
        Lista<Character> lista = new Lista<>();
        for (int i = 0; i < texto.length(); i++) {
            lista.insertar(texto.charAt(i), i);
        }
        return lista;
    }

    @Test
    public void testSecuenciaBienFormada() {
        
        ILista<Character> lista = convertirAListaDeCaracteres("{{}}{{}{}}");
        assertTrue(ControladorDeCorchetes.validacionDeSecuencia(lista));
    }

    @Test
    public void testSecuenciaMalFormada() {
        ILista<Character> lista = convertirAListaDeCaracteres("{{}}{{");
        assertFalse(ControladorDeCorchetes.validacionDeSecuencia(lista));
    }

    @Test
    public void testSecuenciaMalFormada2() {
        ILista<Character> lista = convertirAListaDeCaracteres("{{}}}}");
        assertFalse(ControladorDeCorchetes.validacionDeSecuencia(lista));
    }

    @Test
    public void testSecuenciaVacia() {
        ILista<Character> lista = convertirAListaDeCaracteres("");
        assertFalse(ControladorDeCorchetes.validacionDeSecuencia(lista));
    }

    @Test
    public void testSecuenciaNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ControladorDeCorchetes.validacionDeSecuencia(null);});
    }

    @Test
    public void testUnSoloCaracter() {
        ILista<Character> lista = convertirAListaDeCaracteres("{");
        assertFalse(ControladorDeCorchetes.validacionDeSecuencia(lista));
        ILista<Character> lista2 = convertirAListaDeCaracteres("}");
        assertFalse(ControladorDeCorchetes.validacionDeSecuencia(lista2));
    }
}
