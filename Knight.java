package model;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  Knight Actor
 *  Knights move in L shapes, of every possible orientation.
 *
 *  @author Loran Steinberger (bkwrm215)
 *  @author Robert Scheible (scheible)
 *  @author Jack Cobb (jack3)
 *  @version (2012.12.09)
 */
public class Knight extends Piece
{
    //~ Fields ................................................................

    private Location local;
    private ArrayList<Location> legalMoves;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Knight object.
     * @param color true if white and false if black
     * @param location
     * @param posInArray the position in the array of those color pieces
     */
    public Knight(boolean color, Location location, int posInArray)
    {
        super(color, location, posInArray);
        local = location;
        legalVectors.add(new Location (-2, -1));
        legalVectors.add(new Location (-2, 1));
        legalVectors.add(new Location (-1, -2));
        legalVectors.add(new Location (-1, 2));
        legalVectors.add(new Location (1, -2));
        legalVectors.add(new Location (1, 2));
        legalVectors.add(new Location (2, -1));
        legalVectors.add(new Location (2, 1));

        legalMoves = new ArrayList<Location>();

    }

    //~ Methods ...............................................................
    /**
     * getLegalMoves
     * @param board The board on which the move is being checked
     *
     * @return legalMoves for the knight at this location.
     *
     */
    public ArrayList<Location> getLegalMoves(Piece[][] board)
    {
        legalMoves.clear();

        for (Location vector : this.getLegalVectors())
        {
            if ((local.x() + vector.x() < 8) && (local.x() + vector.x() > -1)
                && (local.y() + vector.y() < 8)
                && (local.y() + vector.y() > -1))
            {
                if (board[vector.x() + local.x()][vector.y()
                    + local.y()] == null
                    || board[vector.x() + local.x()][vector.y()
                        + local.y()].getIsWhite() != this.getIsWhite())
                {
                    legalMoves.add(new Location (vector.x() + local.x(), vector.y() + local.y()));
                }
                else
                {
                    continue;
                }
            }
        }
        return legalMoves;
    }

    public void setLocal(Location local)
    {
        this.local = local;
        super.setLocal(local);
    }



}
