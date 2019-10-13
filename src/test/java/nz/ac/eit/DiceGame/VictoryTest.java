package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VictoryTest {


    private Dice dice1;
    private Dice dice2;
    private Player humanPlayer;
    private Player computerPlayer;


    @Before
    public void setup() {
        dice1 = new Dice();
        dice2 = new Dice();
        humanPlayer = new Player(1, "Human");
        computerPlayer = new Player(2, "Computer");
    }

    @Test
    public void shouldRunningTotalsOfBothPlayersBeEqual_Draw() {

    }

    @Test
    public void shouldRunningTotalPlayer1Be21_Nothing() {

    }

    @Test
    public void shouldRunningTotalPlayer1BeAbove21_GameOver() {

    }

    //check for


}
