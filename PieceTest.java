package model;

/**
 * // -------------------------------------------------------------------------
/**
 *  Test class for the piece class and its encompassing methods
 *
 *  @author Jack Cobb
 *  @author Robert Scheible
 *  @author Loran Steinberger
 *  @version May 3, 2013
 */
public class PieceTest extends student.TestCase
{
    //Fields
    Piece peper;

    /**
     * it runs before each test
     */
    public void setUp()
    {
        peper = new Piece(false, new Location(2, 3), 0);
    }

    /**
     * test get is white method
     */
    public void testGetIsWhite()
    {
        assertFalse(peper.getIsWhite());
    }

    /**
     * tests the set and get active
     */
    public void testActive()
    {
        assertFalse(peper.getIsActive());

        peper.setIsActive(true);

        assertTrue(peper.getIsActive());

    }

    // The rest of the methods are tested in the various game piece classes

}
