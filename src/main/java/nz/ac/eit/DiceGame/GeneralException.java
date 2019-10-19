package nz.ac.eit.DiceGame;

public class GeneralException extends Exception {

    private boolean trueOrFalse;

    public GeneralException(boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }


    //a message with the invalid input is returned
    @Override
    public String getMessage() {
        return "This method has give a false result :" + trueOrFalse + "";
    }

}