package model;

// -------------------------------------------------------------------------
/**
 * Tests the game class
 *
 * @author Robert Scheible (scheible)
 * @author Jack Cobb
 * @author Loran Steingberger
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
     * Tests Castling
     */
    public void testCastle()
    {
        Piece[][] board = game.getBoard();
        board[5][7] = null;
        board[6][7] = null;
        game.setBoard(board);
        game.print();
        game.updateAttackSquares();
        game.updateAvailableMoves();
        System.out.println(game.getAvailableMoves());
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
     * test get board
     */
    public void testGetBoard()
    {
        assertNotNull(game.getBoard());
    }

    /**
     *test the white moves at the beginning
     */
    public void testWhiteMoves()
    {
        assertEquals(20, game.getWhiteAttackingMoves().size());
        assertEquals(20, game.getWhiteAvailableMoves().size());
    }

    /**
     * test for the black moves at the beginning
     */
    public void testBlackMoves()
    {
        assertEquals(20, game.getBlackAttackingMoves().size());
    }

    /**
     * tests the ending of the turns
     */
    public void testEndTurn()
    {
        game.endTurn();
        assertFalse(game.getWhiteTurn());

        game.endTurn();
        assertTrue(game.getWhiteTurn());
    }


}

