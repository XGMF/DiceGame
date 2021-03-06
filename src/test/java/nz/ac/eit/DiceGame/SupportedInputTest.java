package nz.ac.eit.DiceGame;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupportedInputTest {

    private InputCollector inputCollector;

    @Before
    public void setup() {
        inputCollector = new InputCollector();
    }

    @Test(expected = StringNotValidInputException.class)
    public void collectInput_withUnsupportedInput_shouldThrowException() throws StringNotValidInputException {
        inputCollector.collectString("Q");
    }

    @Test
    public void collectString_shouldReturn_r_SupportedInput() throws StringNotValidInputException {
        SupportedInput inputtedString = inputCollector.collectString("r");
        assertEquals(SupportedInput.R, inputtedString);
    }

    @Test
    public void collectString_shouldReturn_h_SupportedInput() throws StringNotValidInputException {
        SupportedInput inputtedString = inputCollector.collectString("h");
        assertEquals(SupportedInput.H, inputtedString);
    }

    @Test
    public void collectString_shouldReturn_R_SupportedInput() throws StringNotValidInputException {
        SupportedInput inputtedString = inputCollector.collectString("R");
        assertEquals(SupportedInput.R, inputtedString);
    }


    @Test
    public void collectString_shouldReturn_H_SupportedInput() throws StringNotValidInputException {
        SupportedInput inputtedString = inputCollector.collectString("H");
        assertEquals(SupportedInput.H, inputtedString);
    }

}