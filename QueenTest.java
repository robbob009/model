package model;

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the Queen class
 *
 *  @author Robert Scheible (scheible)
 *  @version Apr 16, 2013
 */
public class QueenTest extends student.TestCase
{
    /**
     * Tests getting all of the queens legal moves.
     */
    public void testQueenMoves()
    {
        Game game = new Game();
        game.clearBoard();

        Piece[][] board = new Piece[8][8];
        board[3][3] = new Queen(true, new Location (3, 3), 0);
        Piece[] white = new Piece[15];
        white[0] = board[3][3];
        game.setWhitePieces(white);

        ArrayList<Location> moves = board[3][3].getLegalMoves(board);
        for (Location move : moves)
        {
            System.out.println(move.toString());
        }
    }
}
