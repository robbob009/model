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
        game.setWhiteTurn(false);
        game.print();
        game.endTurn();
        //game.print();
        assertTrue(game.isInCheck());
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
        game.move(new Move(game.getBlackPieces()[0], new Location(4, 4)));
        game.move(new Move(game.getWhitePieces()[4], new Location(6, 7)));
        game.move(new Move(game.getBlackPieces()[0], new Location(5, 2)));

        assertNull(game.getBoard()[4][4]);
        assertNull(game.getWhitePieces()[0]);
        //game.print();
    }

    /**
     * Tests the constructor which allows for putting in own values
     */
    public void testConstructorTwo()
    {
        Piece[][] board = new Piece[8][8];
        Piece[] whitePiece = new Piece[16];
        Piece[] blackPiece = new Piece[16];
        board[0][0] = whitePiece[0] = new Rook(true, new Location (0, 0), 0);
        board[1][1] = whitePiece[4] = new King(true, new Location(1, 1), 4);
        board[7][7] = blackPiece[0] = new Rook(false, new Location (7, 7), 0);
        board[6][6] = blackPiece[4] = new King(false, new Location (6, 6), 0);

        Game game = new Game(board, whitePiece, blackPiece, true);
        game.print();
        game.updateAvailableMoves();

        for (Move move : game.getAvailableMoves())
        {
            System.out.println(move.toString());
        }
    }
}
