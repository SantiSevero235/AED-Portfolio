package org.ta2;

public class Marcapasos {
    short presionSanguinea; // 2 bytes
    short frecCardiaca; // 2 bytes
    short nivelAzucar; // 2 bytes

    long maxFuerza; // 8 bytes
    float minTiempoLatidos; // 4 bytes
    double batRestante; // 8 bytes
    char[] codigoFabricante = new char[8]; // 2 bytes, 2 bytes por caracter
                                            // 2x8 = 16 bytes
}

// 2+2+2+2+4+8+16 = 40 bytes