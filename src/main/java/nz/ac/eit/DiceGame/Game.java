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
        int currentDice1;
        int currentDice2;

            // play dice
            currentDice1 = Dice.roll();
            currentDice2 = Dice.roll();
            
            System.out.print(currentDice1 +" "+currentDice2+"\n"+player1.sum(currentDice1, currentDice2));
            
            // update score of current player
            //currentPlayer.updateScore(sum(currentDice1,currentDice2));
            
            // switch players
            //if(currentPlayer == player1) {
            //    currentPlayer = player2;
            
       	 
       	 System.out.println("\n"+ "Please Roll or Hold (R/H)" );
       	 String inputAsString=scan.nextLine().toUpperCase();
       	 
       	 try {
       		 supportedInput=collector.collectString(inputAsString);
            }
            catch (StringNotValidInputException lnse){
                System.out.println(lnse.getMessage());
                System.exit(1);
            }
       	 
       	 RollOrHold(inputAsString);
            
            

    }
    
	public String RollOrHold(String roll) {
		
		//System.out.print(roll);
		
		if(roll.contentEquals("H")) {
			System.out.print("The player has chosen to hold.\n "+"It is now the computers turn");
			
		}else {
			System.out.print("The player has rolled the dice\n");
			//int dice1= myDice.RollDieOne();
			//int dice2= myDice.RollDieTwo();
			
		
		}
		
		
		
		return roll;
		
	}
	
    
    
}
    


    /**
     *  Display winner based on score value
     */
    /**
    private Player winner() {
        if(player1.score > player2.score) {
            return player1;
        } else if(player2.score > player1.score) {
            return player2;
        } else {
            return null;
        }
    }
    
    
     *  Play the game with following sequential steps:
     *  1. Roll dice
     *  2. Update score of current player based on dice value from above step.
     *  3. Switch current player.
     *  4. Repeat steps from 1 untill playCounter is zero (repeat that many times).
     *  5. Outside above loop, check which player has higher score. Display winner, or tie.
    
    public void play() {
        Player currentPlayer = player1; // start with this player
        int currentDice;
        int playCounter = 10;  // play till this count
        
        while(playCounter-- > 0) {
            // play dice
            currentDice = Dice.roll();
            
            // update score of current player
            currentPlayer.updateScore(currentDice);
            
            // switch players
            if(currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
        
        // display winner, or game tie
        if(winner() != null) {
            System.out.println(winner() + " WINS !");
        } else {
            System.out.println("Game tie !");
        }
    }
     */
    
