package model;

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
 * /** Tests the knight class.
 *
 * @author Robert Scheible (scheible)
 * @author Jack Cobb (jack3)
 * @author Loran Steinberger
 * @version Apr 16, 2013
 */
public class KnightTest
    extends student.TestCase
{

    /**
     * The game on which the tests take place.
     */
    private Game game;
    private Piece[] makeM;


    /**
     * Creates a new game to test.
     */
    public void setUp()
    {
        game = new Game();
        makeM = game.getBlackPieces();
    }

    /**
     * test for finding valid moves at the start
     */
    public void testFindMove()
    {

        ArrayList<Move> check = makeM[1].getPossibleMoves(game.getBoard());

        assertEquals(2, check.size());
    }

    /**
     * test for finding valid moves after a pawn has been moved to open up
     * the board a little bit more
     *
     */
    public void testFindMoreMoves()
    {
        Move move1 = new Move(makeM[11], new Location(3, 2));
        game.move(move1);

        ArrayList<Move> check = makeM[1].getPossibleMoves(game.getBoard());

        assertEquals(3, check.size());

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
