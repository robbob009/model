package model;

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the Queen class
 *
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @author Loran Steinberger
 *  @version Apr 16, 2013
 */
public class QueenTest extends student.TestCase
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
     * Tests getting all of the queens legal moves.
     */
//    public void testQueenMoves()
//    {
//        Game game = new Game();
//        game.clearBoard();
//
//        Piece[][] board = new Piece[8][8];
//        board[3][3] = new Queen(true, new Location (3, 3), 0);
//        Piece[] white = new Piece[15];
//        white[0] = board[3][3];
//        game.setWhitePieces(white);
//
//        ArrayList<Location> moves = board[3][3].getLegalMoves(board);
//        for (Location move : moves)
//        {
//            System.out.println(move.toString());
//        }
//    }
}
