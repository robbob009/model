package model;

import java.util.*;

// -------------------------------------------------------------------------
/**
 * King Actor Kings can move one space in any direction. This piece must be
 * captured to win the game.
 *
 * @author Loran Steinberger (bkwrm215)
 * @author Robert Scheible (scheible)
 * @author Jack Cobb (jack3)
 * @version (2012.12.09)
 */
public class King
    extends Piece
{
    // ~ Fields ................................................................

    // ~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new BlackKing object.
     *
     * @param color
     *            true if white and false if black
     * @param location
     *            The location of the piece
     * @param posInArray
     *            the position in the array of those color pieces
     */
    public King(boolean color, Location location, int posInArray)
    {
        super(color, location, posInArray);
        legalVectors.add(new Location(-1, -1));
        legalVectors.add(new Location(-1, 0));
        legalVectors.add(new Location(-1, 1));
        legalVectors.add(new Location(0, -1));
        legalVectors.add(new Location(0, 1));
        legalVectors.add(new Location(1, -1));
        legalVectors.add(new Location(1, 0));
        legalVectors.add(new Location(1, 1));

    }


    // ~ Methods ...............................................................

    /**
     * getLegalMoves method
     *
     * @param board
     *            The board on which the legal move is being looked for
     * @return gives ArrayList of int arrays containing the coordinate pairs
     *         (delta x, delta y) of legal moves
     */
    public ArrayList<Move> getPossibleMoves(Piece[][] board)
    {
        ArrayList<Move> legalMoves = new ArrayList<Move>();

        for (Location vector : this.getLegalVectors())
        {
            if (local.x() + vector.x() < 8 && local.x() + vector.x() > -1
                && local.y() + vector.y() < 8 && local.y() + vector.y() > -1)
            {
                if (board[local.x() + vector.x()][local.y() + vector.y()] == null)
                {
                    legalMoves.add(new Move(this, new Location(vector.x()
                        + local.x(), vector.y() + local.y())));
                }
                else if (board[local.x() + vector.x()][local.y() + vector.y()]
                    .getIsWhite() != this.getIsWhite())
                {
                    legalMoves.add(new Move(this, new Location(vector.x()
                        + local.x(), vector.y() + local.y())));
                }
            }

            else
            {
                continue;
            }
        }

        return legalMoves;
    }

}
