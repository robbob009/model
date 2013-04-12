package model;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Tests the chessboard class
 *
 *  @author Robert Scheible (scheible)
 *  @version Apr 12, 2013
 */
public class ChessboardTest extends student.TestCase
{
    Chessboard board;


    // ----------------------------------------------------------
    /**
     * Sets up initial test conditions
     */
    public void setUp()
    {
        board = new Chessboard();
    }

    /**
     * Tests the clear method
     */
    public void testClearBoard()
    {
        board.clearBoard();

        for (int ii = 0; ii < 8; ii++)
        {
            for (int jj = 0; jj < 8; jj++)
            {
                assertNull(board.getBoard()[ii][jj]);
            }
        }
    }

    /**
     * Tests the check method
     */
    public void testCheck()
    {
        board.clearBoard();

        Piece[] black = board.getBlackPieces();
        Piece[] white = board.getWhitePieces();

        white[4] = new King(true, new Location (2, 2), 4, board);
        black[4] = new King(false, new Location (4, 4), 4, board);

        black[0] = new Rook(false, new Location (2, 4), 0, board);
        ArrayList<Piece> givingCheck = board.check(white, black);
        assertEquals(1, givingCheck.size());
    }

}
