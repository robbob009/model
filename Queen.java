package model;

//-------------------------------------------------------------------------
/**
 *  Queen Piece
 *  The Queen moves diagonally and straight in 8 different directions.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.08)
 */
public class Queen extends Piece
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Queen object.
     * @param color true if white and false if black
     * @param location The location of the piece
     * @param posInArray the position in the array of those color pieces
     */
    public Queen(boolean color, Location location, int posInArray)

    {
        super(color, location, posInArray);

        legalVectors.add(new Location (-1, -1));
        legalVectors.add(new Location (-1, 0));
        legalVectors.add(new Location (-1, 1));
        legalVectors.add(new Location (0, -1));
        legalVectors.add(new Location (0, 1));
        legalVectors.add(new Location (1, -1));
        legalVectors.add(new Location (1, 0));
        legalVectors.add(new Location (1, 1));

    }
    //~ Methods ...............................................................

}
