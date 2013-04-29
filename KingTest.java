package model;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  This is the test class for the king piece class. This is used for testing
 *  code and can be used for debugging.
 *
 *  @author Jack Cobb (jack3)
 *  @author Loran Steinberger
 *  @author Robert Schieble (scheible)
 *
 *  @version Apr 23, 2013
 */
public class KingTest extends student.TestCase
{
    /**
     * The game on which the tests take place.
     */
    Game game;
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
        ArrayList<Move> check = makeM[4].getPossibleMoves(game.getBoard());

        assertEquals(0, check.size());
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

        ArrayList<Move> check = makeM[4].getPossibleMoves(game.getBoard());

        assertEquals(1, check.size());

    }
}
