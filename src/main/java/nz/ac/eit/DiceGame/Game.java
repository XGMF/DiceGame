package nz.ac.eit.DiceGame;

import java.util.Scanner;

class Game {

    Player player1;
    Player player2;
    Dice dice, dice1;

    ////
    Player currentPlayer;

    Scanner scan = new Scanner(System.in);
    InputCollector collector = new InputCollector();

    InputCollector input = null;
    SupportedInput supportedInput = null;

    private boolean switchPlayer = false;

    /**
     * Game object constructor
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

        // play dice


        //the limit is 21. IF the value is over 21, fail.
        while (isUnderGameLimit(currentPlayer.getRunningTotal())) {////////////////////////////////////////////////////////////////////

            int currentDice1 = Dice.roll();
            int currentDice2 = Dice.roll();

            int aSum = currentPlayer.sum(currentDice1, currentDice2);
            int aRunningTotal = currentPlayer.runningTotal(aSum);

            System.out.println(currentPlayer.getName());
            System.out.print(currentDice1 + " " + currentDice2 + "\n" + aSum + "\n" + "Running Total :" + aRunningTotal);

            //checks whether the total is over the ending condition
            //if it is STOP.
            System.out.println(isUnderGameLimit(aRunningTotal)+"\n");

            System.out.println("\n" + "Please Roll or Hold (R/H)");
            String inputAsString = scan.nextLine().toUpperCase();

            try {
                supportedInput = collector.collectString(inputAsString);
            } catch (StringNotValidInputException lnse) {
                System.out.println(lnse.getMessage());
                System.exit(1);
            }

            ;

            if (currentPlayer == player2 && currentPlayer.getRunningTotal() > 14) {
                ///////hold
                player2.setHold(true);
            }


            /**
             * Player check
             * if the player has chosen to hold, the current player us switched.
             */
            if (currentPlayer == player1 && switchPlayer == true) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }




        }///////////////////////////////////////////////////////////////////////
    }

    /**
     * Checks if the player holds or rolls.
     * only checks one condition at the moment
     */
    public String RollOrHold(String roll) {

        //System.out.print(roll);

        if (roll.contentEquals("H")) {
            System.out.print("The player has chosen to hold.\n " + "It is now the computers turn" + "\n");
            switchPlayer = true;

            ////TODO computer
            /*



            if (currentPlayer.getRunningTotal() < 16) {
                currentPlayer.setHold(true);
            }
            if (player1.getHold() && player2.getHold() == true) {
                //////////
                compareScores();


            }
             */

            /**
             * If the player holds, it is the computers turn.
             * Vice versa, if its the computers turn and holds
             * it is the players turn.
             */
        } else {
            System.out.print("The player has rolled the dice\n");
            switchPlayer = false;
            /**
             * If the player rolls the dice nothing happens here.
             * Returns to the beginning of the loop
             */
        }
        return roll;
    }

    /**
     * In the event both players hold, check scores!
     */
    private void compareScores() {
        int target = 21;

        if (target - player1.getRunningTotal() < target - player2.getRunningTotal()) {
            System.out.println(("Player 1 victory"));
        } else
            System.out.println("Player 2 victory");
    }

    /**
     * Responsible for checking limit conditions.
     */
    public static boolean isUnderGameLimit(int value) {

        if (value > 21) {
            System.out.println("The current total is above 21");
            System.exit(1); //if it is over, the game is over. Print related crap.
            return false;
        } else {
            System.out.println("Less Than21");
            return true;
        }

        /**
         *7 being the most common number
         * if computer's total becomes 9<21
         */
    }
}
