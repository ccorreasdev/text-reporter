package org.dawone.textreporter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FactOfTheDayLineReaderTest {

    @Test
    void readLines_SiEsHoy_DevuelveLaFrase() {
        String apiEndpoint = "https://uselessfacts.jsph.pl//api/v2/facts/today";
        FactOfTheDayLineReader factOfTheDayLineReaderMock = Mockito.mock(FactOfTheDayLineReader.class);
        String[] expected = {"The first owner of the Marlboro company died of lung cancer."};

        when(factOfTheDayLineReaderMock.readLines()).thenReturn(expected);

        assertEquals(expected, factOfTheDayLineReaderMock.readLines());
    }

    @Test
    void readLines_SiEsHoy_DevuelveCadena() {
        String apiEndpoint = "https://uselessfacts.jsph.pl//api/v2/facts/today";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);
        String[] lineasLeidas = reader.readLines();
        int tamanyoCadena = lineasLeidas.length;
        int tamanyoMinimo = 1;
        boolean expected = true;
        boolean actual = false;

        if(tamanyoCadena >= tamanyoMinimo){
            actual = true;
        }

        assertEquals(expected, actual);
    }

    @Test
    void readLines_SiNoHayEndPoint_DevuelveExcepcion() {
        String apiEndpoint = "";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);

        assertThrows(IllegalArgumentException.class, () -> reader.readLines());
    }

    @Test
    void readLines_SiEndPointErroneo_DevuelveExcepcion() {
        String apiEndpoint = "nofunciona";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);

        assertThrows(RuntimeException.class,()-> reader.readLines() );
    }
}