package org.dawone.textreporter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextReporterTest {

    @Test
    void reportIsWordUsed_SiCoincidePalabra_DevuelveTrue() {
        String apiEndpoint = "https://uselessfacts.jsph.pl//api/v2/facts/today";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);
        WordProcessor wordProcessor = new WordProcessor();
        TextReporter textReporter = new TextReporter(reader, wordProcessor);

        String wordToCheck = "the";
        boolean isUsed = textReporter.reportIsWordUsed(wordToCheck);

        assertEquals(true, isUsed);
    }

    @Test
    void reportIsWordUsed_SiNoCoincidePalabra_DevuelveFalse() {
        String apiEndpoint = "https://uselessfacts.jsph.pl//api/v2/facts/today";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);
        WordProcessor wordProcessor = new WordProcessor();
        TextReporter textReporter = new TextReporter(reader, wordProcessor);

        String wordToCheck = "asdfghjklqwertyuiop";
        boolean isUsed = textReporter.reportIsWordUsed(wordToCheck);

        assertEquals(false, isUsed);
    }

    @Test
    void reportIsWordUsed_SiNoHayPalabra_DevuelveExcepcion() {
        String apiEndpoint = "https://uselessfacts.jsph.pl//api/v2/facts/today";
        FactOfTheDayLineReader reader = new FactOfTheDayLineReader(apiEndpoint);
        WordProcessor wordProcessor = new WordProcessor();
        TextReporter textReporter = new TextReporter(reader, wordProcessor);

        String wordToCheck = " ";

        assertThrows(IllegalArgumentException.class, () ->   textReporter.reportIsWordUsed(wordToCheck));
    }


}