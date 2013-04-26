package model;

import java.util.Scanner;
import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the AIGame
 *
 * @author Robert Scheible (scheible)
 * @version Apr 12, 2013
 */
public class AIGameTest
    extends TestCase
{

    // ----------------------------------------------------------
    /**
     * Tests the run method
     */
    public void testRun()
    {
        AIGame sample = new AIGame();
        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        for (int ii = 0; ii < 400; ii++)
        {
            System.out.println(game.getAttackingMoves());
            System.out.println(game.getAvailableMoves());
            String input = scan.nextLine();
            System.out.println(sample.makeMove(input, game));
            game.print();
        }
    }
}
