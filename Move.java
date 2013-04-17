package model;

/**
 * // -------------------------------------------------------------------------
/**
 *  This class contains the information for a move: the location
 *  and the piece making it.
 *
 *  @author Robert Scheible (scheible)
 *  @version Apr 16, 2013
 */
public class Move
{
    // ----------------------------------------------------------

    private Piece piece;
    private Location local;

    /**
     * Create a new Move object.
     * @param piece
     * @param local
     */
    public Move(Piece piece, Location local)
    {
        this.piece = piece;
        this.local = local;
    }


    // ----------------------------------------------------------
    /**
     * Gets the piece contained in the move.
     * @return the piece
     */
    public Piece getPiece()
    {
        return piece;
    }

    /**
     * Gets the Location contained in the move.
     * @return the location.
     */
    public Location getLocal()
    {
        return local;
    }

    /**
     * Returns the String representation of the move
     */
    public String toString()
    {
        String output = "";
        if (piece != null)
        {
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
        }

        output += local.toString();

        return output;
    }
}
