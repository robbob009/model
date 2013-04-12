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
        AIGame game = new AIGame();
        Chessboard board = new Chessboard();

        for (int ii = 0; ii < 50; ii++)
        {
            System.out.println(game.run(board));
        }
    }
}