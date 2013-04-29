package model;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  This is the test class for the rook game piece class. It is used for testing
 *  the existing code and can be used for further debugging of the code.
 *
 *  @author Jack Cobb
 *  @author Robert Scheible
 *  @author Loran Steinberger
 *
 *  @version Apr 23, 2013
 */
public class RookTest extends student.TestCase
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
        ArrayList<Move> check = makeM[3].getPossibleMoves(game.getBoard());

        assertEquals(0, check.size());
    }

    /**
     * test for finding valid moves after a pawn has been moved to open up
     * the board a little bit more
     *
     */
    public void testFindMoreMoves()
    {
        Move move1 = new Move(makeM[8], new Location(0, 3));
        game.move(move1);

        ArrayList<Move> check = makeM[0].getPossibleMoves(game.getBoard());

        assertEquals(2, check.size());

    }
}
