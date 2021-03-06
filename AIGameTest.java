package model;


// -------------------------------------------------------------------------
/**
 * Tests the AIGame
 *
 * @author Robert Scheible (scheible)
 * @author Jack Cobb (jack3)
 * @author Loran Steinberger
 * @version Apr 12, 2013
 */
public class AIGameTest
    extends student.TestCase
{
    AIGame game;

    /**
     * the setup method
     */
    public void setUp()
    {
        game = new AIGame();

    }

    /**
     * tests for the AIgame get num value
     */
    public void testGetNumValue()
    {
        // tests rook
        Rook rook = new Rook(false, null, 0);
        assertEquals(5, game.getNumValue(rook));

        // tests bishop
        Bishop b = new Bishop(false, null, 1);
        assertEquals(3,game.getNumValue(b));

        //tests knight
        Knight k = new Knight(false, null, 2);
        assertEquals(3, game.getNumValue(k));

        //tests queen
        Queen q = new Queen(false, null, 3);
        assertEquals(9, game.getNumValue(q));

        //tests pawn
        Pawn p = new Pawn(false, null, 4);
        assertEquals(1, game.getNumValue(p));
    }

}