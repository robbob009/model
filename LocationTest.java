package model;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the location class
 *
 *  @author Robert Scheible (scheible)
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
        assertEquals(local.toString(), "(2, 3)");
    }
}