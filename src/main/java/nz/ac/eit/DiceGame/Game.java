package nz.ac.eit.DiceGame;

import java.util.Scanner;

class Game {


    Player humanPlayer; //human player
    Player computerPlayer; //computer player
    Dice dice1, dice2; //two dice for the game

    private int cpuHoldNumber = 7;//an arbitrary number for the cpu to decide when to hold.
    //So for 7, the computer will hold when 7 away from 21.

    private static int gameTarget = 21; //The number stated in the requirements


    Scanner scan = new Scanner(System.in);
    InputCollector collector = new InputCollector();

    InputCollector input = null;
    SupportedInput supportedInput = null;

    //signifies the end of the game when triggered//
    private static boolean end = false;

    /////////////////////////////////////////////////////////////////////////////////////
    //Constructor

    /**
     * Game object constructor
     */
    Game() {
        // instantiate two players
        humanPlayer = new Player(1, "Human Player");
        computerPlayer = new Player(2, "Computer");

        // instantiate dice object
        dice1 = new Dice();
        dice2 = new Dice();
    }

    /////////////////////////////////////////////////////////////////////////////
    //Methods

    public int diceRollOne() {
        int aDice = Dice.roll();
        return aDice;

    }

    public int diceRollTwo() {
        int aDice = Dice.roll();
        return aDice;
    }

    public void play() {

        //while the game is not finished//
        while (end != true) {////////////////////////////////////////////////////////////////////

            //////each dice is rolled and assigned to a variable
            int currentDice1 = diceRollOne();
            int currentDice2 = diceRollTwo();

            //////both die are summed and a total is given
            int aSum = humanPlayer.sum(currentDice1, currentDice2);
            int aRunningTotal = humanPlayer.runningTotal(aSum);

            //display the current player, die and sum
            System.out.println("Player 1: ");
            System.out.print(currentDice1 + " " + currentDice2 + "\n" + aSum + "\n" + "Running Total :" + aRunningTotal);

            //checks whether the total is over the ending condition
            //if it is STOP. is game under limit includes a condition for closing the app.
            System.out.println(victoryLimitCheck(aRunningTotal) + "\n");

            //asking the player for input. Input collector and exception class is linked.
            System.out.println("Please Roll or Hold (R/H)");
            String inputAsString = scan.nextLine().toUpperCase();

            //Test if the input is supported, if not pass back a message.
            //Currently close on invalid input. Should loop asking for a valid input.
            try {
                supportedInput = collector.collectString(inputAsString);
            } catch (StringNotValidInputException stringNotValidInputException) {
                System.out.println(stringNotValidInputException.getMessage());
                System.exit(1);
            }

            //takes checked string and checks whether to player has chosen to hold or roll.
            RollOrHold(inputAsString);
        }///////////////////////////////////////////////////////////////////////
    }


    /**
     * Checks if the player holds or rolls.
     * only checks one condition at the moment
     */
    public boolean RollOrHold(String roll) {

        //System.out.print(roll);
        //uses string buffer.
        if (roll.contentEquals("H")) {
            System.out.print("The player has chosen to hold.\n " + "It is now the computers turn" + "\n");
            System.out.println("Hello");// currentPlayer);
            humanPlayer.setHold(true);

            computerLogic();
            /**
             * If the player holds, it is the computers turn.
             * Vice versa, if its the computers turn and holds
             * it is the players turn.
             */
            return true;
        } else {
            System.out.print("The player has rolled the dice\n");
            /**
             * If the player rolls the dice nothing happens here.
             * Returns to the beginning of the loop
             */
            return false;
        }

    }

    /**
     * Responsible for checking limit conditions the it is the players turn.
     */
    public boolean victoryLimitCheck(int diceRunningTotalPlayer) {
        //game target is 21, as stated in the requirements.
        if (diceRunningTotalPlayer > gameTarget) {
            System.out.println("The current total is above 21\n" +
                    "Game Over! ");
            System.exit(1); //if it is over, the game is over. Print related crap.
            return true;
        } else {
            System.out.println("Less than or equal to 21");
            return false;
        }
    }

    /**
     * Checks that if the running totals are equal, then the game is a draw.
     */
    public boolean drawPlayersHoldCheck(boolean holdPlayer1, boolean holdPlayer2) {
        //boolean humanPlayerHold = humanPlayer.getHold();
        //boolean computerPlayerHold = computerPlayer.getHold();
        int runningTotalPlayer1 = humanPlayer.getRunningTotal();
        int runningTotalPlayer2 = computerPlayer.getRunningTotal();


        if (holdPlayer1 && holdPlayer2 == true) {
            //split the function to allow for testing, do not create a dependency
            //Using a getter is a dependency......\


            drawRunningTotalCheck(runningTotalPlayer1, runningTotalPlayer2);
            return true;
        }
        return false;
    }


    ////refactored from draw
    public boolean drawRunningTotalCheck(int runningTotal1, int runningTotal2) {

        if (runningTotal1 == runningTotal2) {
            System.out.println("The game is a draw");
            System.exit(1); //exit the game
            return true;
        } else {
            return false;

        }
    }
    ///
    //other conditions


    /**
     * The player has held, the computer must do something.
     * Once the player holds, the computer will continue to roll until it gets within a range
     * for holding. One each loop the victory conditions are checked.
     * It is possible for the computer to lose without holding as the range is smaller than
     * 12 which is a the total for a two dice roll.
     */
    public void computerLogic() {
        //The dice are rolled
        //here, the human player has chosen to hold and the computer will loop through the game
        //until the end.
        while (humanPlayer.getHold() == true) {
            int die1 = diceRollOne();
            int die2 = diceRollTwo();

            //The dice is rolled
            System.out.println("The computer rolls :\n" + "Dice1: " + die1 + " Dice2: " + die2);

            //stuff is calculated
            int anotherSum = computerPlayer.sum(die1, die2);
            int computerDiceTotal = computerPlayer.runningTotal(anotherSum);

            //the victory condition is checked and displayed
            victoryLimitCheck(computerDiceTotal);
            System.out.println("Human Player Dice Total: " + humanPlayer.getRunningTotal() + "\n" +
                    " " + "Computer Player Dice Total" + computerDiceTotal + "\n");

            //if the current total of computer is closer than a certain number
            if (gameTarget - computerDiceTotal < cpuHoldNumber) {
                computerPlayer.setHold(true);
                int humanDiceTotal = humanPlayer.getRunningTotal();

                //who is closer to the target.
                //The closest is the winner
                if ((gameTarget - humanDiceTotal < gameTarget - computerDiceTotal)) {

                    System.out.print("Player 1 wins!");
                    scan.nextLine();//pauses after game is completed.
                } else {
                    drawRunningTotalCheck(humanDiceTotal, computerDiceTotal);
                    /////////////////////////////////put in draw
                    //System.out.println ("The computer rolls :\n" +die1 + " : "+ die2);
                    //System.out.println ("Computer current total:\n"+computerDiceTotal);
                    System.out.println("The computer wins");
                    scan.nextLine();//pauses after game is completed
                }
            } else {
                //do nothing, continue
            }
        }
    }
}









