package org.dawone.textreporter;

import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {

    @org.junit.jupiter.api.Test
    void getWords_SiEsNull_DevuelveExcepcion() {
        WordProcessor wordProcessor = new WordProcessor();

        assertThrows(IllegalArgumentException.class, () ->   wordProcessor.getWords(null));
    }

    @org.junit.jupiter.api.Test
    void getWords_SiHayPalabras_DevuelvePalabrasSeparadas() {
        WordProcessor wordProcessor = new WordProcessor();
        String cadenaASeparar = "hola es un ejemplo";
        String[] cadenaSeparada = wordProcessor.getWords(cadenaASeparar);
        String[] expected = {"hola", "es", "un", "ejemplo"};

        assertArrayEquals(expected, cadenaSeparada);
    }

    @org.junit.jupiter.api.Test
    void getWords_SiHayPalabrasMayusculas_DevuelvePalabrasSeparadas() {
        WordProcessor wordProcessor = new WordProcessor();
        String cadenaASeparar = "Es otro ejemplo";
        String[] cadenaSeparada = wordProcessor.getWords(cadenaASeparar);
        String[] expected = {"es", "otro", "ejemplo"};

        assertArrayEquals(expected, cadenaSeparada);
    }






}