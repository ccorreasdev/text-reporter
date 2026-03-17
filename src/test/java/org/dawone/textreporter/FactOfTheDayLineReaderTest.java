package org.dawone.textreporter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactOfTheDayLineReaderTest {

    @Test
    void readLines_SiEsHoy_DevuelveLaFrase() {
        String apiEndpoint = "https://uselessfacts.jsph.pl//api/v2/facts/today";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);
        String[] lineasLeidas = reader.readLines();
        String expected = "The first owner of the Marlboro company died of lung cancer.";

        assertEquals(expected, lineasLeidas[0]);
    }

    @Test
    void readLines_SiNoHayEndPoint_DevuelveExcepcion() {
        String apiEndpoint = "";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);

        assertThrows(IllegalArgumentException.class, () -> reader.readLines());
    }
}