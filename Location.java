package model;

/**
 * // -------------------------------------------------------------------------
 * /** This is a location.
 *
 * @author Robert Scheible (scheible)
 * @author Jack Cobb
 * @author Loran Steinberger
 * @version Feb 20, 2013
 */
public class Location
{
    private int xCoord;
    private int yCoord;


    /**
     * Creates a new Location object
     *
     * @param x
     *            is the x coordinate of the location
     * @param y
     *            is the y coordinate of the location
     */
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }


    /**
     * Determines if one location is equal to another
     *
     * @param newLocal
     *            is the new location being checked against the current location
     * @return if the objects are equal
     */
    public boolean equals(Object newLocal)
    {
        return newLocal != null && newLocal.getClass() == this.getClass()
            && ((Location)newLocal).x() == xCoord
            && ((Location)newLocal).y() == yCoord;
    }

    public String toString()
    {
        String output = "";

        switch (xCoord)
        {
            case (0):
                output += "a";
                break;
            case (1):
                output += "b";
                break;
            case (2):
                output += "c";
                break;
            case (3):
                output += "d";
                break;
            case (4):
                output += "e";
                break;
            case (5):
                output += "f";
                break;
            case (6):
                output += "g";
                break;
            case (7):
                output += "h";
                break;
        }

        output += (8 - yCoord);
        return output;
    }


    /**
     * Returns the x coordinate of the location
     *
     * @return the x coordinate
     */
    public int x()
    {
        return xCoord;
    }


    /**
     * Returns the y coordinate of the location
     *
     * @return the y coordinate
     */
    public int y()
    {
        return yCoord;
    }
}
