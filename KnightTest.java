package model;

import java.util.ArrayList;

public class KnightTest extends student.TestCase
{

    Chessboard board;

    public void setUp()
    {
        board = new Chessboard();
    }

    public void testMove()
    {
    assertNull(board.getBoard()[0][5]);
    board.move(board.getWhitePieces()[1], new Location (0, 5));

    assertNotNull(board.getBoard()[0][5]);
    ArrayList<Location> moves = board.getWhitePieces()[1].getLegalMoves(board.getBoard());

    System.out.println(board.getBoard()[0][5].toString());
    System.out.println(board.getWhitePieces()[1].toString());
    for (Location move : moves)
    {
        System.out.println(move.toString());
    }

    }
}
