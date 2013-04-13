package model;

import java.util.ArrayList;

public class PawnTest extends student.TestCase
{
    Chessboard board;

    public void setUp()
    {
        board = new Chessboard();
    }

    /**
     * Tests the white pawn moves starting at b2
     */
    public void testPawnB2()
    {
        ArrayList<Location> moves = board.getWhitePieces()[9].getLegalMoves(board.getBoard());
        System.out.println(board.getWhitePieces()[9].getLocal().x());
        System.out.println(board.getWhitePieces()[9].getLocal().y());
        assertEquals(2, moves.size());
        assertEquals(new Location(1, 5), moves.get(0));
        assertEquals(new Location(1, 4), moves.get(1));
    }

    /**
     * Tests the white pawn moves at b2, when it can take
     * pieces at a3 and c3
     */
    public void testPawnTakeB2()
    {
        Piece[] black = board.getBlackPieces();

        black[8].setLocal(new Location(0, 5));
        black[10].setLocal(new Location(2, 5));

        board.setBlackPieces(black);
        Piece[][] chessBoard = board.getBoard();
        chessBoard[0][1] = null;
        chessBoard[2][1] = null;
        chessBoard[0][5] = black[8];
        chessBoard[2][5] = black[10];

        ArrayList<Location> moves = board.getWhitePieces()[9].getLegalMoves(board.getBoard());
        assertEquals(4, moves.size());
        assertEquals(new Location(1, 5), moves.get(0));
        assertEquals(new Location(2, 5), moves.get(1));
        assertEquals(new Location(0, 5), moves.get(2));
        assertEquals(new Location(1, 4), moves.get(3));
        board.print();
    }

    public void testMove()
    {
        assertNull(board.getBoard()[1][4]);
        board.move(board.getWhitePieces()[9], new Location (1, 4));

        assertNotNull(board.getBoard()[1][4]);
        ArrayList<Location> moves = board.getWhitePieces()[9].getLegalMoves(board.getBoard());
        for (Location move : moves)
        {
            System.out.println("(" + move.x() + ", " + move.y() + ")");
        }
    }


}
