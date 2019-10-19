package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {



    // @Test
    // public void DiceNumber_returnsTypeInt_True() {

    //}

    @Test
    public void mustReturnBetween_1and6Inclusive() {

        int number = Dice.roll();
            assertEquals("The number is less than 7 and greater than 0 first ", number > 0 && number < 7, true);
        }

}