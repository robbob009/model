package model;

/**
 * // -------------------------------------------------------------------------
 * /** This is a location.
 *
 * @author Robert Scheible (scheible)
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


    /**
     * Prints the coordinates of the location to a string, using chess
     * coordinates
     * @param piece the piece that the location is being found for
     * @return the coordinates of the location
     */
    public String toString(Piece piece)
    {

        String output = "";

        if (piece.getClass() == King.class)
        {
            output += "K";
        }
        else if (piece.getClass() == Queen.class)
        {
            output += "Q";
        }
        else if (piece.getClass() == Rook.class)
        {
            output += "R";
        }
        else if (piece.getClass() == Bishop.class)
        {
            output += "B";
        }
        else if (piece.getClass() == Knight.class)
        {
            output += "N";
        }

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

        output += (8 - yCoord) + " " + xCoord + ", " + yCoord;
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
