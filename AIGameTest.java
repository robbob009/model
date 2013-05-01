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
    /**
     * Tests the run method
     */
    public void testRun()
    {
        AIGame sample = new AIGame();
        sample.playGame();
    }
}