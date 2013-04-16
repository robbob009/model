package model;

import java.util.Iterator;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Tests the game class
 *
 * @author Robert Scheible (scheible)
 * @version Apr 12, 2013
 */
public class GameTest
    extends student.TestCase
{

    /**
     * The game used in all tests
     */
    Game game;


    // ----------------------------------------------------------
    /**
     * Sets up initial test conditions
     */
    public void setUp()
    {
        game = new Game();
    }


    /**
     * Tests the clear method
     */
    public void testClearBoard()
    {
        game.clearBoard();

        for (int ii = 0; ii < 8; ii++)
        {
            for (int jj = 0; jj < 8; jj++)
            {
                assertNull(game.getBoard()[ii][jj]);
            }
        }
    }


    /**
     * Tests the check method
     */
    public void testCheck()
    {
        game.clearBoard();

        game.add(new King(true, new Location(2, 2), 4));
        game.add(new King(false, new Location(4, 4), 4));
        game.add(new Rook(false, new Location(2, 4), 0));

        ArrayList<Piece> givingCheck = game.check();
        assertEquals(1, givingCheck.size());
    }


    /**
     * Tests getting the list of legal moves for
     */
    public void testLegalMoves()
    {
        game.clearBoard();

        game.add(new King(true, new Location(2, 2), 4));
        game.add(new King(false, new Location(7, 7), 4));
        game.add(new Rook(false, new Location(5, 2), 2));

        Piece[] pieces = game.getWhitePieces();

        ArrayList<Piece> piecesWithMoves = new ArrayList<Piece>();
        ArrayList<Location> movesWithPieces = new ArrayList<Location>();

        for (Piece piece : pieces)
        {
            if (piece != null)
            {
                for (Location move : piece.getLegalMoves(game.getBoard()))
                {
                    piecesWithMoves.add(piece);
                    movesWithPieces.add(move);
                }
            }
        }
        Iterator<Location> LIter = movesWithPieces.iterator();
        Iterator<Piece> PIter = piecesWithMoves.iterator();

        while (LIter.hasNext())
        {
            if (!game.isLegalMove(PIter.next(), LIter.next()))
            {
                LIter.remove();
                PIter.remove();
            }
        }

        for (int ii = 0; ii < piecesWithMoves.size(); ii++)
        {
            System.out.println(movesWithPieces.get(ii).toString(
                piecesWithMoves.get(ii)));
        }

    }

    /**
     * Tests the game's ability to take a piece.
     */
    public void testTake()
    {
        game.clearBoard();

        game.add(new King(true, new Location(7, 7), 4));
        game.add(new King(false, new Location(0, 0), 4));
        game.add(new Pawn(true, new Location(4, 4), 0));
        game.add(new Knight(false, new Location(5, 2), 0));
        game.setWhiteTurn(false);
        game.move(game.getBlackPieces()[0], new Location(4, 4));
        game.move(game.getWhitePieces()[4], new Location(6, 7));
        game.move(game.getBlackPieces()[0], new Location(5, 2));

        assertNull(game.getBoard()[4][4]);
        assertNull(game.getWhitePieces()[0]);
        game.print();
    }
}
