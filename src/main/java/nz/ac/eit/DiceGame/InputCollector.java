package nz.ac.eit.DiceGame;

import java.util.Scanner;

public class InputCollector {


    public SupportedInput collectString(String inputAsString) throws StringNotValidInputException {
    	SupportedInput input=null;
        try {
            input = SupportedInput.valueOf(inputAsString.toUpperCase());
        }
        catch (IllegalArgumentException iae){
            throw new StringNotValidInputException(inputAsString);
        }
        return input;
    }
}