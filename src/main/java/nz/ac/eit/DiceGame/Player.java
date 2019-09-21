package nz.ac.eit.DiceGame;

public class Player {

	 int id;
	    String name;
	    int score;
	    
	    public Player(int id, String name) {
	        this.id = id;
	        this.name = name;
	        this.score = 0;
	    }
	    
	    /**
	     *  Update player score
	     */
	    public void updateScore(int sumOfCurrentDice) {
	        score += sumOfCurrentDice;
	        System.out.format("\n%s \tscore = %d\n", name, score);
	    }
	    
	    public int sum(int dice1, int dice2) {
	    	int sum=(dice1+dice2);
	    	return sum;
	    }
	    
	    /**
	     * 
	     */
	    
	    
	    @Override
	    public String toString() {
	        return name + " [" + score + "]";
	    }
	
}
