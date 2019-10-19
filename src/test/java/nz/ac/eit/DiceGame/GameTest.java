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

        //inputCollector = new InputCollector();
    }

    //rollOrHold()
    //return true for hold


    //@Test (expected = GeneralException.class)
    //public void shouldThrowException() throws GeneralException {
    //    game.RollOrHold("sas");
    //}

    //  drawRunningTotalCheck()
    @Test
    public void drawRunningTotalCheck_2020_true() {
        assertEquals(game.drawRunningTotalCheck(20, 20), true);
    }

    @Test
    public void drawRunningTotalCheck_1920_false() {
        assertEquals(game.drawRunningTotalCheck(22, 21), false);
    }

    @Test
    public void drawRunningTotalCheck_2019_false() {
        assertEquals(game.drawRunningTotalCheck(21, 22), false);
    }

    @Test
    public void drawRunningTotalCheck_2121_true() {
        assertEquals(game.drawRunningTotalCheck(21, 21), true);
    }

    @Test
    public void drawRunningTotalCheck_1621_false() {
        assertEquals(game.drawRunningTotalCheck(16, 21), false);
    }


    // draw()
    @Test
    public void draw_trueTrue_2020_true() {
        assertEquals(game.drawPlayersHoldCheck(true, true), true);
    }

    @Test
    public void drawFalseTrue_false() {
        assertEquals(game.drawPlayersHoldCheck(false, true), false);
    }

    @Test
    public void draw_TrueFalse_false() {
        assertEquals(game.drawPlayersHoldCheck(true, false), false);
    }

    @Test
    public void draw_FalseFalse_false() {
        assertEquals(game.drawPlayersHoldCheck(false, false), false);
    }

    //@Test (expected = GeneralException.class)
    //public void draw_falseTrue_true() throws GeneralException {
    //    game.drawPlayersHoldCheck(false, true);
    //}

    //@Test (expected = GeneralException.class)
    //public void draw_trueTalse_true() {
    //    assertEquals(game.drawPlayersHoldCheck(true, false), false);
    //}

    //victoryLimitCheck()
    @Test
    public void victoryLimitCheck_20_shouldReturn_False() {
        assertEquals(game.victoryLimitCheck(20), false);
    }

    @Test
    public void victoryLimitCheck_16ShouldNotReturn_False() {
        assertEquals(game.victoryLimitCheck(16), false);
    }

    @Test
    public void victoryLimitCheck_21_shouldReturn_False() {
        assertEquals(game.victoryLimitCheck(21), false);
    }

    //@Test
    //public void victoryLimitCheck_22_shouldReturn_False() {
    //   assertEquals(game.victoryLimitCheck(22), false);
    //}


}
