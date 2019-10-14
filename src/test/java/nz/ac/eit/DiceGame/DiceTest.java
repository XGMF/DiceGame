package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unsure on how to test
 */
public class DiceTest {

    /**
     *Maybe test that the dice will not be less that one ot greater than six.

     public int dice()  {
     Dice dice=new Dice();

     }
     */

    private Dice dice1;
    private Dice dice2;

    //check for random dice.
    //create dice ready to roll.
    @Before
    public void setup() {
        dice1 = new Dice();
        dice2 = new Dice();
    }

    ///check for a sequence of numbers??
    @Test
    public void shouldReturnTwoRandomNumbersEachTime() {

    }

    //check that a number cannot exist out of range
    @Test
    public void shouldThrowAnExceptionIfDiceIs0() {

    }

    @Test
    public void shouldThrowAnExceptionIfDiceIs7() {

    }

    //check valid numbers on
    @Test
    public void should1ThrownShouldAccept() {

    }

    @Test
    public void should6ThrownShouldAccept() {

    }



}
