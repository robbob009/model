package model;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Tests the pawn class.
 *
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @author Loran Steinberger
 *  @version Apr 16, 2013
 */
public class PawnTest
    extends student.TestCase
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
        ArrayList<Move> check = makeM[10].getPossibleMoves(game.getBoard());

        assertEquals(2, check.size());
    }

    /**
     * test for finding valid moves after a pawn has been moved to open up
     * the board a little bit more. It is also checking to make sure that the
     * pawn doesn't try to move 2 spaces again
     *
     */
    public void testFindMoreMoves()
    {
        Move move1 = new Move(makeM[8], new Location(0, 2));
        game.move(move1);

        ArrayList<Move> check = makeM[8].getPossibleMoves(game.getBoard());

        assertEquals(1, check.size());
    }


}
