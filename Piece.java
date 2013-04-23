package model;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Piece Actor contains methods pertinent to all chess pieces
 *
 * @author Loran Steinberger (bkwrm215)
 * @author Robert Scheible (scheible)
 * @author Jack Cobb (jack3)
 * @version (2012.12.03)
 */
public class Piece
{
    // ~ Fields ................................................................

    private boolean               isWhite;
    private boolean               isActive;
    private ArrayList<Move>       legalMoves;

    /**
     * The location needs to be used in the subclasses
     */
    protected Location            local;
    private int                   inColorArray;

    /**
     * legalVectors will be overwritten by every chess piece upon construction.
     */
    protected ArrayList<Location> legalVectors;


    // ~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Piece object.
     *
     * @param color
     *            true if white and false if black.
     * @param location
     * @param posInArray
     *            the position in the array holding all of that color pieces
     */
    public Piece(boolean color, Location location, int posInArray)
    {
        inColorArray = posInArray;
        isWhite = color;
        local = location;
        isActive = false;
        legalVectors = new ArrayList<Location>();
    }


    // ~ Methods ...............................................................

    /**
     * get Legal Moves given legal vectors, finds legal moves for a specific
     * piece.
     *
     * @param board
     *            The board the move is being checked on
     * @return returns all legal moves for the piece at this location
     */
    public ArrayList<Move> getPossibleMoves(Piece[][] board)
    {
        legalMoves = new ArrayList<Move>();

        for (Location vector : this.getLegalVectors())
        {
            for (int i = 1; i < 8; i++)
            {
                if ((local.x() + i * vector.x() < 8)
                    && (local.x() + i * vector.x() > -1)
                    && (local.y() + i * vector.y() < 8)
                    && (local.y() + i * vector.y() > -1))
                {
                    if (board[local.x() + i * vector.x()][local.y() + i
                        * vector.y()] == null)
                    {
                        legalMoves.add(new Move(this, new Location(vector.x()
                            * i + local.x(), vector.y() * i + local.y())));
                    }
                    else if ((board[local.x() + i * vector.x()][local.y() + i
                        * vector.y()].getIsWhite()) != this.getIsWhite())
                    {
                        legalMoves.add(new Move(this, new Location(vector.x()
                            * i + local.x(), vector.y() * i + local.y())));
                        break;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return legalMoves;
    }


    /**
     * checks if one piece is equal to another.
     *
     * @param piece
     *            is the piece that this is being compared with.
     * @return true of the pieces are the same.
     */
    public boolean equals(Piece piece)
    {
        return this.getIsWhite() == piece.getIsWhite()
            && this.local == piece.getLocal()
            && this.getInColorArray() == piece.getInColorArray();
    }


    /**
     * This would return a char, except that if the class is a pawn it must
     * return ""
     *
     * @return the letter representing the piece in algebraic notation.
     */
    public String getLetter()
    {
        if (getClass() == King.class)
        {
            return "K";
        }
        else if (getClass() == Queen.class)
        {
            return "Q";
        }
        else if (getClass() == Rook.class)
        {
            return "R";
        }
        else if (getClass() == Bishop.class)
        {
            return "B";
        }
        else if (getClass() == Knight.class)
        {
            return "N";
        }
        return "";
    }


    /**
     * Prints out the piece to a string
     */
    public String toString()
    {
        String output = "";
        if (getIsWhite())
        {
            output += "White ";
        }
        else
        {
            output += "Black ";
        }

        output += getClass() + " at " + this.getLocal().toString();

        return output;

    }


    /**
     * Returns the position of the piece in the array of that color
     *
     * @return the position of the piece in the array of that color
     */
    public int getInColorArray()
    {
        return inColorArray;
    }


    public Piece clone()
    {
        return new Piece(
            isWhite,
            new Location(local.x(), local.y()),
            inColorArray);
    }


    /**
     * get Is White
     *
     * @return true if a piece is white and false if a piece is black
     */
    public boolean getIsWhite()
    {
        return isWhite;
    }


    // ----------------------------------------------------------
    /**
     * Gets the location of the piece
     *
     * @return the piece's location
     */
    public Location getLocal()
    {
        return local;
    }


    // ----------------------------------------------------------
    /**
     * Sets the location of the piece
     *
     * @param local
     *            the loaction to be set to
     */
    public void setLocal(Location local)
    {
        this.local = local;
    }


    /**
     * get Is Active activation is dependent on has a piece been touched by a
     * user, and are its legal moves displayed on the board.
     *
     * @return true if activated and false if inactivated.
     */
    public boolean getIsActive()
    {
        return isActive;
    }


    /**
     * getLegalVectors
     *
     * @return all possible legal vectors for this piece
     */
    public ArrayList<Location> getLegalVectors()
    {
        return legalVectors;
    }


    /**
     * set Is Active
     *
     * @param activity
     *            true if active and false if inactive.
     */
    public void setIsActive(boolean activity)
    {
        isActive = activity;
    }
}
