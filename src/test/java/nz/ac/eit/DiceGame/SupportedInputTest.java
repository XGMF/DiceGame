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
        //InputCollector inputCollector = new InputCollector();
        inputCollector.collectString("Q");
    }

    @Test
    public void collectString_shouldReturn_R_SupportedInput() throws StringNotValidInputException {
        //InputCollector inputCollector = new InputCollector();
        SupportedInput string = inputCollector.collectString("R");
        assertEquals("R", string);
    }

    @Test
    public void collectString_shouldReturn_H_SupportedInput() throws StringNotValidInputException {
        //InputCollector inputCollector = new InputCollector();
        SupportedInput string = inputCollector.collectString("H");
        assertEquals("H", string);
    }

}