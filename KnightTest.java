package model;

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
 * /** Tests the knight class.
 *
 * @author Robert Scheible (scheible)
 * @version Apr 16, 2013
 */
public class KnightTest
    extends student.TestCase
{

    /**
     * The game on which the tests take place.
     */
    Game game;


    /**
     * Creates a new game to test.
     */
    public void setUp()
    {
        game = new Game();
    }

    /**
     * Tests the knight moving.
     */
//    public void testMove()
//    {
//        assertNull(game.getBoard()[0][5]);
//        game.move(game.getWhitePieces()[1], new Location(0, 5));
//
//        assertNotNull(game.getBoard()[0][5]);
//        ArrayList<Location> moves =
//            game.getWhitePieces()[1].getLegalMoves(game.getBoard());
//
//        System.out.println(game.getBoard()[0][5].toString());
//        System.out.println(game.getWhitePieces()[1].toString());
//        for (Location move : moves)
//        {
//            System.out.println(move.toString());
//        }
//    }
}
