package nz.ac.eit.DiceGame;

import java.util.Scanner;





public class InputCollector {
	


    public SupportedInput collectString(String languageAsString) throws StringNotValidInputException {
    	SupportedInput input=null;
        try {
        	input = SupportedInput.valueOf(languageAsString.toUpperCase());
        }
        catch (IllegalArgumentException iae){
            throw new StringNotValidInputException(languageAsString);
        }
        return input;
    }
	
	
	
	
	
	
	
}