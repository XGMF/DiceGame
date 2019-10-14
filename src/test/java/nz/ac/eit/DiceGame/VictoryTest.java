package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VictoryTest {


    private Dice dice1;
    private Dice dice2;
    private Player humanPlayer;
    private Player computerPlayer;
    private Game game;

    @Before
    public void setup() {
        dice1 = new Dice();
        dice2 = new Dice();
        game = new Game();
        humanPlayer = new Player(1, "Human");
        computerPlayer = new Player(2, "Computer");
        //
        //humanPlayer.setHold(true);
        //computerPlayer.setHold(true);
    }

    @Test
    public void shouldRunningTotalsOfBothPlayersBeEqual_Draw() {


    }

    @Test
    public void shouldRunningTotalPlayer1Be15_True_gameContinues() {
        int aNumber = humanPlayer.runningTotal(15);
        boolean victory = game.victoryLimitCheck(aNumber);
        assertEquals("Less than or equal to 21", true, victory);

    }


    @Test
    public void shouldRunningTotalPlayer1Be21_True_gameContinues() {
        int aNumber = humanPlayer.runningTotal(21);
        boolean victory = game.victoryLimitCheck(aNumber);
        assertEquals("Less than or equal to 21", true, victory);

    }

    @Test //should fail
    public void shouldRunningTotalPlayer1Be22_false_GameOver() {
        int aNumber = humanPlayer.runningTotal(22);
        boolean victory = game.victoryLimitCheck(aNumber);
        assertFalse("Above 21, the game is over", victory);
    }

    //check for


}

