package nz.ac.eit.DiceGame;

public class Dice {

    /**
     *  Roll the dice and return random number between 1 and 6 (both inclusive)
     */


	public static int roll() {
		return 1 + (int)(Math.random() * 6);
	}
	
	
}
