package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private Player player1, player2;
    private Dice dice;

    @Before
    public void setup() {

        game = new Game();
        dice = new Dice();
        player1 = new Player(1, "human_player");
        player2 = new Player(2, "computer_player");
    }

    //if above 21 the game is over.
    @Test
    public void limitCheck_20_shouldReturn_True() {
        assertEquals(game.victoryLimitCheck(20), true);
    }

    @Test
    public void limitCheck_21_shouldReturn_True() {
        assertEquals(game.victoryLimitCheck(21), true);
    }

    @Test
    public void limitCheck_22_shouldReturn_False() {
        assertEquals(game.victoryLimitCheck(22), false);
    }

    @Test
    public void limitCheck_22ShouldNotReturn_True() {
        assertEquals(game.victoryLimitCheck(22), true);
    }


}
