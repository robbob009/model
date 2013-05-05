package model;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the location class
 *
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb
 *  @author Loran Steinberger
 *  @version Feb 20, 2013
 */
public class LocationTest extends student.TestCase
{
    private Location local;

    /**
     * Sets up the test for Location
     */
    public void setUp()
    {
        local = new Location(2, 3);
    }

    /**
     * Tests the equals() method
     */
    public void testEquals()
    {
        assertEquals(local, new Location(2, 3));
    }

    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        assertEquals(local.toString(), "c5");

    }

    /**
     * tests for the rest of the outputs
     */
    public void testToStringMore()
    {
        Location l1 = new Location(0, 0);
        Location l2 = new Location(1, 1);
        Location l3 = new Location(2, 2);
        Location l4 = new Location(3, 3);
        Location l5 = new Location(4, 4);
        Location l6 = new Location(5, 5);
        Location l7 = new Location(6, 6);
        Location l8 = new Location(7, 7);

        assertEquals("a8", l1.toString());
        assertEquals("b7", l2.toString());
        assertEquals("c6", l3.toString());
        assertEquals("d5", l4.toString());
        assertEquals("e4", l5.toString());
        assertEquals("f3", l6.toString());
        assertEquals("g2", l7.toString());
        assertEquals("h1", l8.toString());
    }
}