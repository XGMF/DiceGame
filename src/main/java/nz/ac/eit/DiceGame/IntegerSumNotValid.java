package nz.ac.eit.DiceGame;

public class IntegerSumNotValid extends Exception {

    private int aNumber;

    public IntegerSumNotValid(int aNumber) {
        this.aNumber = aNumber;
    }

    @Override
    public String getMessage() {
        return "The sum " + aNumber + " is not correct";
    }


}
