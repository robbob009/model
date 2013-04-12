package model;

import junit.framework.TestCase;

public class AIGameTest extends TestCase
{
    public void testRun()
    {
        AIGame game = new AIGame();
        Chessboard board = new Chessboard();

        for (int ii = 0; ii < 50; ii++)
        {
            System.out.println(game.run(board));
        }
    }
}