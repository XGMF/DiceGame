package nz.ac.eit.DiceGame;

public class StringNotValidInputException extends Exception {
	
	private String rollOrHold;
	
    public StringNotValidInputException(String rollOrHold) {
        this.rollOrHold=rollOrHold;
    }
    
    
    //a message with the invalid input is returned 
    @Override
    public String getMessage() {
        return "The key "+rollOrHold+" is not supported";
    }

}
