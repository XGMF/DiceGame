package nz.ac.eit.DiceGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player(1, "Human_Player");
    }

    @Test
    public void sum_1and1_return2() {
        assertEquals(player.sum(1, 1), 2);
    }

    @Test
    public void sum_6and6_return12() {
        assertEquals(player.sum(6, 6), 12);
    }

    @Test
    public void sum_2and4_return6() {
        assertEquals(player.sum(2, 4), 6);
    }

    //not throwing, but correct, should NOT be equal.
    @Test(expected = IntegerSumNotValid.class)
    public void sum_3and1_return6() throws IntegerSumNotValid {
        assertEquals(player.sum(1, 1), 3);
    }
}
