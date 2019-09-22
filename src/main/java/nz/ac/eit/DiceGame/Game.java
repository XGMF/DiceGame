package nz.ac.eit.DiceGame;

import java.util.Scanner;

class Game {

	Player player1;
    Player player2;
    Dice dice, dice1;
    
    Scanner scan=new Scanner(System.in);
    InputCollector collector=new InputCollector();
    
    InputCollector input = null;
    SupportedInput  supportedInput = null;

    private boolean switchPlayer =false;

    /**
     *  Game object constructor
     */
    Game() {
        // instantiate two players
        player1 = new Player(1, "Player1");
        player2 = new Player(2, "Computer");
        
        // instantiate dice object
        dice = new Dice();
    }
    
    
    public void play() {

        Player currentPlayer = player1; // start with this player

            while(isUnderGameLimit(currentPlayer.getRunningTotal())) {////////////////////////////////////////////////////////////////////

                // play dice
                int currentDice1 = Dice.roll();
                int currentDice2 = Dice.roll();
                int aSum =currentPlayer.sum(currentDice1,currentDice2);
                int aRunningTotal= currentPlayer.runningTotal(aSum);

                System.out.println(currentPlayer);
                System.out.print(currentDice1 + " " + currentDice2 + "\n" + aSum+"\n"+"Running Total :"+aRunningTotal);

                System.out.println("\n" + "Please Roll or Hold (R/H)");
                String inputAsString = scan.nextLine().toUpperCase();

                try {
                    supportedInput = collector.collectString(inputAsString);
                } catch (StringNotValidInputException lnse) {
                    System.out.println(lnse.getMessage());
                    System.exit(1);
                }

                //asks user if it wants to Roll or Hold, will switch to computer on hold, or vice versa
                RollOrHold(inputAsString);
                //checks whether the total is over the ending condition
                isUnderGameLimit(aRunningTotal);

                /**
                 * Player check
                 * if the player has chosen to hold, the current player us switched.
                 */
                if(currentPlayer == player1&&switchPlayer==true) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
            }///////////////////////////////////////////////////////////////////////
    }

    /**
     *Checks if the player holds or rolls.
     * only checks one condition at the moment
     */
	public String RollOrHold(String roll) {
		
		//System.out.print(roll);
		
		if(roll.contentEquals("H")) {
			System.out.print("The player has chosen to hold.\n "+"It is now the computers turn"+"\n");
            switchPlayer=true;

            ////TODO computer

			/**
             * If the player holds, it is the computers turn.
             * Vice versa, if its the computers turn and holds
             * it is the players turn.
             */
		}else {
			System.out.print("The player has rolled the dice\n");
            switchPlayer=false;
			/**
             * If the player rolls the dice nothing happens here.
             * Returns to the beginning of the loop
			 */
		}
		return roll;
	}

    /**
     * Responsible for checking limit conditions.
     */
    public static boolean isUnderGameLimit(int value) {

        if (value > 21) {
            System.out.println("Over 21");
            return false;
        } else {
            System.out.println("Less Than21");
            return true;
        }
    }
    
    
}
