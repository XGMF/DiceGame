package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DiceTest {

    Dice dice;

    @Before
    public void setup() {
        dice = new Dice();
    }

    // @Test
    // public void DiceNumber_returnsTypeInt_True() {

    //}

    @Test
    public void mustReturnBetween_1and6Inclusive() {

        int number = Dice.roll();

        for (int i = 0; i < 10000000; i++) {
            assertEquals("The number is less than 7 and greater than 0 first ", number > 0 && number < 7, true);
        }

    }


}
