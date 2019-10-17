package nz.ac.eit.DiceGame;

import java.util.Scanner;

class Game {


    Player humanPlayer; //human player
    Player computerPlayer; //computer player
    Dice dice1, dice2; //two dice for the game

    private int cpuHoldNumber =7;//an arbitrary number for the cpu to decide when to hold.
    //So for 7, the computer will hold when 7 away from 21.

    private static int gameTarget = 21; //The number stated in the requirements


    Scanner scan = new Scanner(System.in);
    InputCollector collector = new InputCollector();

    InputCollector input = null;
    SupportedInput supportedInput = null;

    //signifies the end of the game when triggered//
    private static boolean end =false;

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
        dice2= new Dice();
    }

    /////////////////////////////////////////////////////////////////////////////
    //Methods


    public void play() {

        //while the game is not finished//
        while (end!=true) {////////////////////////////////////////////////////////////////////

            //////each dice is rolled and assigned to a variable
            int currentDice1 = Dice.roll();
            int currentDice2 = Dice.roll();

            //////both die are summed and a total is given
            int aSum = humanPlayer.sum(currentDice1, currentDice2);
            int aRunningTotal = humanPlayer.runningTotal(aSum);

            //display the current player, die and sum
            System.out.println("Player 1: ");
            System.out.print(currentDice1 + " " + currentDice2 + "\n" + aSum + "\n" + "Running Total :" + aRunningTotal);

            //checks whether the total is over the ending condition
            //if it is STOP. is game under limit includes a condition for closing the app.
            System.out.println(victoryLimitCheck(aRunningTotal)+"\n");

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
    public void RollOrHold(String roll) {

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
        } else {
            System.out.print("The player has rolled the dice\n");
            /**
             * If the player rolls the dice nothing happens here.
             * Returns to the beginning of the loop
             */
        }
        //return roll;
    }

    /**
     * Responsible for checking limit conditions the it is the players turn.
     */
    public boolean victoryLimitCheck(int diceRunningTotalPlayer) {
        //game target is 21, as stated in the requirements.
        if (diceRunningTotalPlayer > gameTarget) {
            System.out.println("The current total is above 21\n" +
                    "The current player has lost! ");
            System.exit(1); //if it is over, the game is over. Print related crap.
            return false;
        } else {
            System.out.println("Less than or equal to 21");
            return true;
        }
    }

    /**
     * Checks that if the running totals are equal, then the game is a draw.
     */
    public boolean draw(boolean runningTotalPlayer1, boolean runningTotalPlayer2) {
        boolean humanPlayerHold = humanPlayer.getHold();
        boolean computerPlayerHold = computerPlayer.getHold();


        if (humanPlayerHold && computerPlayerHold == true) {
            //split the function to allow for testing, do not create a dependency
            //Using a getter is a dependency......
        }
        if (runningTotalPlayer1 == runningTotalPlayer2) {
            System.out.println("The game is a draw");
            return true;
        } else {
            return false;
        }

    }

    ///
    //other conditions




    /**
     * The player has held, the computer must do something.
     * Once the player holds, the computer will continue to toll until it gets within a range
     * for holding. Once the computer holds, victory conditions are checked.
     * It is possible for the computer to lose without holding as the range is smaller than
     * 12 which is a the total for a two dice roll.
     */
    public void computerLogic() {
        //The dice are rolled
        //here, the human player has chosen to hold and the computer will loop through the game
        //until the end.
        while(humanPlayer.getHold()==true) {
            int die1 = Dice.roll();
            int die2 = Dice.roll();

            //The dice is rolled
            System.out.println ("The computer rolls :\n" +die1 + " : "+ die2);

            //stuff is calculated
            int anotherSum = computerPlayer.sum(die1, die2);
            int computerDiceTotal = computerPlayer.runningTotal(anotherSum);

            //the victory condition is checked and displayed
            victoryLimitCheck(computerDiceTotal);
            System.out.println(humanPlayer.getRunningTotal()+" "+computerDiceTotal);

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









