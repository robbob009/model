package model;

/**
 * // -------------------------------------------------------------------------
/**
 * Test class for the move class and its encompassing methods
 *
 *  @author Jack Cobb
 *  @author Robert Scheible
 *  @author Loran Steinberger
 *  @version May 3, 2013
 */
public class MoveTest extends student.TestCase
{

    //Fields
    private Move mom;
    private Rook ron;

    /**
     * sets up the tests each time
     */
    public void setUp()
    {
        ron = new Rook(false, null, 0);
        mom = new Move(ron, new Location(3, 3));

    }

    /**
     * tests the get piece method
     */
    public void testGetPiece()
    {
        assertEquals(ron, mom.getPiece());
    }

    /**
     * tests the get location method
     */
    public void testGetLocation()
    {
        Location loyd = new Location(3, 3);
        assertEquals(loyd, mom.getLocal());
    }

    /**
     * tests the equals method
     */
    public void testEqualsMethod()
    {
        Move m1 = new Move(new Rook(false, null, 0), new Location(3, 3));
        Move m2 = new Move(new Pawn(false, null, 0), new Location(3, 4));

        assertTrue(mom.equals(m1));
        assertFalse(mom.equals(m2));
    }

    /**
     * tests the notation methods and to string method
     */
    public void testNotation()
    {
        mom.setNotation(mom.toString());

        assertEquals("Rd5", mom.getNotation());
    }


}
