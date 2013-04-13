package model;

import java.util.ArrayList;

public class KnightTest extends student.TestCase
{

    Game game;

    public void setUp()
    {
        game = new Game();
    }

    public void testMove()
    {
    assertNull(game.getBoard()[0][5]);
    game.move(game.getWhitePieces()[1], new Location (0, 5));

    assertNotNull(game.getBoard()[0][5]);
    ArrayList<Location> moves = game.getWhitePieces()[1].getLegalMoves(game.getBoard());

    System.out.println(game.getBoard()[0][5].toString());
    System.out.println(game.getWhitePieces()[1].toString());
    for (Location move : moves)
    {
        System.out.println(move.toString());
    }

    }
}
