package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static nz.ac.eit.DiceGame.SupportedInput.H;
import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private Dice dice1;
    private Dice dice2;

    @Before
    public void setup() {

        game = new Game();
        dice1 = new Dice();
        dice2 = new Dice();
        //inputCollector = new InputCollector();
    }

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
    public void draw_trueTrue_True() {
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

    @Test
    public void diceRollOne_shouldReturn_Between1and6Inclusive_true() {
        int number = Dice.roll();
        assertEquals("The number is less than 7 and greater than 0 first ", number > 0 && number < 7, true);
        System.out.println(number);
    }

    @Test
    public void diceRollTwo_shouldReturn_Between1and6Inclusive_true() {
        int number = Dice.roll();
        assertEquals("The number is less than 7 and greater than 0 first ", number > 0 && number < 7, true);
        System.out.println(number);
    }


    @Test
    public void diceRollOne_shouldReturn_LessThan0_false() {
        int number = Dice.roll();
        assertEquals("damn code", number < 0, false);
        System.out.println(number);
    }

    @Test
    public void diceRollTwo_shouldReturn_above6_false() {
        int number = Dice.roll();
        assertEquals("damn code", number > 6, false);
        System.out.println(number);
    }

    @Test
    public void diceRollOne_shouldReturn_moreThan6_false() {
        int number = Dice.roll();
        assertEquals("damn code", number > 6, false);
        System.out.println(number);
    }

    @Test
    public void diceRollTwo_shouldReturn_lessThan0_false() {
        int number = Dice.roll();
        assertEquals("damn code", number < 0, false);
        System.out.println(number);
    }


    // @Test
    // public void rollOrHold (){
    //    assertEquals(game.RollOrHold("H"),H);
}
    /*
    @Test
    public void victoryLimitCheck_22_shouldReturn_True() {
        assertEquals(game.victoryLimitCheck(22), true);
    }


    ////////////////
    @Test
    public void victoryLimitCheck_23_shouldReturnTrue() {
        assertEquals(game.victoryLimitCheck(23), true);
    }

    @Test
    public void victoryLimitCheck_27_shouldReturn_True() {
        assertEquals(game.victoryLimitCheck(27), true);
    }
*/



