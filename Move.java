package model;

/**
 * // -------------------------------------------------------------------------
 * /** This class contains the information for a move: the location and the
 * piece making it.
 *
 * @author Robert Scheible (scheible)
 * @author Jack Cobb
 * @author Loran Steinberger
 * @version Apr 16, 2013
 */
public class Move
{
    // ----------------------------------------------------------

    private Piece    piece;
    private Location local;
    private String notation;


    /**
     * Create a new Move object.
     *
     * @param piece
     * @param local
     */
    public Move(Piece piece, Location local)
    {
        this.piece = piece;
        this.local = local;
        this.setNotation(this.toString());
    }

    /**
     * Creates a new Move with a different notation
     * @param piece
     * @param local
     * @param note
     */
    public Move(Piece piece, Location local, String note)
    {
        this.piece = piece;
        this.local = local;
        this.setNotation(note);
    }


    // ----------------------------------------------------------
    /**
     * Gets the piece contained in the move.
     *
     * @return the piece
     */
    public Piece getPiece()
    {
        return piece;
    }


    /**
     * Gets the Location contained in the move.
     *
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
        return piece.getLetter() + local.toString();
    }


    /**
     * Checks if the two moves are equivalent.
     * @param move is the move this is being checked against.
     * @return whether or not the two moves are equal
     */
    public boolean equals(Move move)
    {
        return this.getLocal().equals(move.getLocal())
            && this.getPiece().equals(move.getPiece());
    }

    /**
     * Gets the String representation of the move.
     * @return the move notation.
     */
    public String getNotation()
    {
        return notation;
    }

    /**
     * Sets the move notation.
     * @param notation the notation of the move.
     */
    public void setNotation(String notation)
    {
        this.notation = notation;
    }
}
