package nz.ac.eit.DiceGame;

public class Player {

	 	private int id;
	    private String name;
	    private int runningTotal;
	    private boolean hold =false;

	public boolean getHold() {
		return hold;
	}

	public void setHold(boolean hold) {
		this.hold = hold;
	}

	public Player(int id, String name) {
	        this.id = id;
	        this.name = name;
	        this.runningTotal=0;
	    }
	    
	    /**
	     *  Update player score
	     */

	    public int sum(int dice1, int dice2) {
	    	int sum=(dice1+dice2);
	    	return sum;
	    }

	    public int runningTotal(int aSum){
	    	 return runningTotal+=aSum;
		}


	public int getRunningTotal() {
		return runningTotal;
	}

	public void setRunningTotal(int runningTotal) {
		this.runningTotal = runningTotal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
