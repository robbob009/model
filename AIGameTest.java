package model;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 *  Tests the AIGame
 *
 *  @author Robert Scheible (scheible)
 *  @version Apr 12, 2013
 */
public class AIGameTest extends TestCase
{

    // ----------------------------------------------------------
    /**
     * Tests the run method
     */
    public void testRun()
    {
        AIGame sample = new AIGame();
        Game game = new Game();

        for (int ii = 0; ii < 100; ii++)
        {
            System.out.println(sample.run(game));
        }
        game.print();
    }
}