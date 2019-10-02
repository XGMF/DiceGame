package nz.ac.eit.DiceGame;


import org.junit.Test;

import static org.junit.Assert.*;

public class SupportedInputTest {


    @Test(expected = StringNotValidInputException.class)
    public void collectLanguage_withUnsupportedLanguage_shouldThrowException() throws StringNotValidInputException {
        InputCollector inputCollector = new InputCollector();
        inputCollector.collectString("Q");
    }

    @Test
    public void collectString_shouldReturn_R_SupportedLanguage() throws StringNotValidInputException {
        InputCollector inputCollector = new InputCollector();
        SupportedInput string = inputCollector.collectString("R");
        assertEquals("R", string);
    }

    @Test
    public void collectString_shouldReturn_H_SupportedLanguage() throws StringNotValidInputException {
        InputCollector inputCollector = new InputCollector();
        SupportedInput string = inputCollector.collectString("H");
        assertEquals("H", string);
    }

}